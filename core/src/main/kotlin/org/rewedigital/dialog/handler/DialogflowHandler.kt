package org.rewedigital.dialog.handler

import org.rewedigital.dialog.extensions.*
import org.rewedigital.dialog.model.dialogflow.DialogflowParams
import org.rewedigital.dialog.model.dialogflow.OutputContext
import org.rewedigital.dialog.model.dialogflow.WebhookRequest
import org.rewedigital.dialog.model.google.Conversation
import org.rewedigital.dialog.model.google.DataStorage
import org.rewedigital.dialog.model.google.SurfaceCapabilities
import org.rewedigital.dialog.model.google.userData

/**
 * Wrapper of [WebhookRequest] which provides utility functions  for easier context access and other parameters.
 * And also provides instance of [DialogflowResponseBuilder].
 */
class DialogflowHandler(private val webhookRequest: WebhookRequest) {

    /**
     * Holds context related information.
     */
    val context: ContextWrapper =
        ContextWrapper(webhookRequest.queryResult?.outputContexts.orEmpty().map {
            // clone the list and remove the session prefix
            it.copy(name = it.name?.replace("${webhookRequest.session.orEmpty()}/contexts/", ""))
        }.toMutableList(), webhookRequest.session.orEmpty())

    /**
     * The action name defined in Dialogflow.
     */
    val action
        get() = webhookRequest.queryResult?.action

    /**
     *  Returns the original request string from Dialogflow.
     */
    val originalRequest
        get() = webhookRequest.queryResult?.queryText

    /**
     *  Indicates if the current session has type of [Conversation.Type.NEW]
     */
    val isNewSession
        get() = webhookRequest.originalDetectIntentRequest?.payload?.conversation?.type == Conversation.Type.NEW

    /**
     * The intent name defined in Dialogflow.
     */
    val intentName
        get() = webhookRequest.queryResult?.intent?.displayName

    /**
     * An unique identifier of the users google account.
     */
    val userId: String?
        get() = webhookRequest.originalDetectIntentRequest?.payload?.user?.userId
            ?: webhookRequest.originalDetectIntentRequest?.payload?.user?.userData?.userId

    /**
     * The stored user data aka user storage.
     * @see https://developers.google.com/actions/assistant/save-data#json
     */
    val userData: DataStorage?
        get() = webhookRequest.originalDetectIntentRequest?.payload?.user?.userData

    /**
     * The unique identifier of detectIntent request session.
     * Can be used to identify end-user inside webhook implementation.
     * Format: projects/<Project ID>/agent/sessions/<Session ID>,
     * or projects/<Project ID>/agent/environments/<Environment ID>/users/<User ID>/sessions/<Session ID>.
     */
    val sessionId: String?
        get() = webhookRequest.session

    /**
     * An OAuth2 token that identifies the user in your system.
     * Only available if Account Linking configuration is defined in the action package
     * and the user links their account.
     */
    val accessToken: String?
        get() = webhookRequest.originalDetectIntentRequest?.payload?.user?.accessToken

    /**
     *  Returns an [DialogflowResponseBuilder] which can be used to construct a complete webhook response
     *  containing speech and visual components.
     */
    val responseBuilder
        get() = DialogflowResponseBuilder(this)

    /**
     * The language that was triggered during intent detection.
     */
    val languageCode
        get() = webhookRequest.queryResult?.languageCode

    /**
     * Returns the fulfillmentText defined in Dialogflow if present.
     */
    val fulfillmentText
        get() = webhookRequest.queryResult?.fulfillmentText

    /**
     * Return the fulfillmentMessages defined in Dialogflow if present.
     */
    val fulfillmentMessages
        get() = webhookRequest.queryResult?.fulfillmentMessages

    /**
     * Returns the confidence score for the intent detection.
     */
    val intentDetectionConfidence
        get() = webhookRequest.queryResult?.intentDetectionConfidence

    /**
     * Returns the confidence score for the speech recognition.
     */
    val speechRecognitionConfidence
        get() = webhookRequest.queryResult?.speechRecognitionConfidence

    /**
     * Returns the [org.rewedigital.dialog.model.google.Input.RawInput.InputType] of the user input.
     */
    val inputType
        get() = webhookRequest.originalDetectIntentRequest?.payload?.inputs?.firstOrNull()?.rawInputs?.firstOrNull()?.inputType

    /**
     * The collection of extracted entities.
     */
    val arguments: Map<String, Any> = webhookRequest.queryResult?.parameters.orEmpty()

    /**
     * Returns the value for the key from [arguments].
     */
    fun getArgument(key: String) = arguments[key]

    fun isGoogleCrawler() = webhookRequest.originalDetectIntentRequest?.payload?.user?.profile
        .let {
            it?.givenName == "Google" && it.familyName == "Crawler"
        }

    /**
     *  Checks if on the last request a permission was successfully granted.
     */
    fun permissionGranted() = webhookRequest.permissionGranted()

    /**
     *  Returns the current sign in status.
     *  Status can be one of [org.rewedigital.dialog.model.google.Status.SignIn].
     */
    fun signInStatus() = webhookRequest.signInStatus()

    /**
     *  Returns the selected option after a [org.rewedigital.dialog.model.google.SystemIntents.OPTION]
     */
    fun selectedOption() = webhookRequest.getSelectedOption()

    /**
     *  Returns true if the request has the given [SurfaceCapabilities]
     */
    fun hasSurfaceCapability(capability: SurfaceCapabilities) = webhookRequest.hasSurfaceCapability(capability)

    /**
     *  Returns the context for the given name.
     */
    fun getContext(name: String): OutputContext? = context[name]

    /**
     * Returns the context parameter value for the given name and key
     */
    fun getContextParam(name: String, key: String): Any? = context[name, key]

    /**
     * Set a context and overwrites the old one, with the same name, if present.
     */
    fun setContext(name: String, lifespan: Int = 4, params: DialogflowParams) {
        context += OutputContext(name, lifespan, params)
    }

    /**
     * Returns all contexts.
     */
    fun getContextList() = context.asList()


    /**
     * Set a context parameter.
     */
    fun setContextParam(name: String, key: String, value: Any) {
        context[name, key] = value
    }

    class ContextWrapper(
        private val context: MutableList<OutputContext>,
        private val session: String
    ) {
        operator fun get(contextName: String) = context.firstOrNull { it.name == contextName }

        operator fun get(contextName: String, parameter: String) = this[contextName]?.parameters?.get(parameter)

        operator fun set(contextName: String, context: OutputContext) {
            this += context.copy(name = contextName)
        }

        operator fun set(contextName: String, parameter: String, value: Any) {
            if (this[contextName] == null) {
                this[contextName] =
                    OutputContext(contextName, lifespanCount = 4, parameters = mutableMapOf(parameter to value))
            } else {
                this[contextName]?.parameters?.set(parameter, value)
            }
        }

        fun hasAnyContext() = context.isEmpty()

        // add the session prefix again
        fun asList() = context.map { it.copy(name = "$session/contexts/${it.name}") }

        operator fun plusAssign(context: OutputContext) {
            this.context.removeIf { it.name == context.name }
            this.context += context
        }
    }
}