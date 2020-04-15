package org.rewedigital.dialog.handler

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.rewedigital.dialog.extensions.*
import org.rewedigital.dialog.model.dialogflow.DialogflowParams
import org.rewedigital.dialog.model.dialogflow.OutputContext
import org.rewedigital.dialog.model.dialogflow.WebhookRequest
import org.rewedigital.dialog.model.google.Conversation
import org.rewedigital.dialog.model.google.SurfaceCapabilities
import java.util.*
import kotlin.collections.HashMap

/**
 * Wrapper of [WebhookRequest] which provides utility functions for easier context access and other parameters.
 * And also provides instance of [DialogflowResponseBuilder].
 */
open class DialogflowHandler(private val webhookRequest: WebhookRequest) {

    /**
     * Holds context related information.
     */
    open val context: ContextWrapper =
        ContextWrapper(webhookRequest.queryResult?.outputContexts.orEmpty().map {
            // clone the list and remove the session prefix
            it.copy(name = it.name?.replace("${webhookRequest.session.orEmpty()}/contexts/", ""))
        }.toMutableList(), webhookRequest.session.orEmpty())

    /**
     * The stored user data aka user storage.
     * @see <a href="https://developers.google.com/actions/assistant/save-data#json">Assistant documentation</a>
     */
    open val userData: MutableMap<String, Any?> = run {
        val userData = webhookRequest.originalDetectIntentRequest?.payload?.user?.userStorage
            ?: return@run mutableMapOf<String, Any?>()
        fromJson(userData).toMutableMap()
    }

    /**
     * The action name defined in Dialogflow.
     */
    open val action
        get() = webhookRequest.queryResult?.action

    /**
     *  Returns the original request string from Dialogflow.
     */
    open val originalRequest
        get() = webhookRequest.queryResult?.queryText

    /**
     *  Indicates if the current session has type of [Conversation.Type.NEW]
     */
    open val isNewSession
        get() = webhookRequest.originalDetectIntentRequest?.payload?.conversation?.type == Conversation.Type.NEW

    /**
     * The intent name defined in Dialogflow.
     */
    open val intentName
        get() = webhookRequest.queryResult?.intent?.displayName

    /**
     * An unique identifier of the users google account.
     */
    open val userId: String
        get() {
            return if (userData.containsKey("userId")) {
                userData["userId"] as String
            } else {
                UUID.randomUUID().toString().also {
                    userData["userId"] = it
                }
            }
        }

    /**
     * The unique identifier of detectIntent request session.
     * Can be used to identify end-user inside webhook implementation.
     * Format: projects/<Project ID>/agent/sessions/<Session ID>,
     * or projects/<Project ID>/agent/environments/<Environment ID>/users/<User ID>/sessions/<Session ID>.
     */
    open val sessionId: String?
        get() = webhookRequest.session

    /**
     * An OAuth2 token that identifies the user in your system.
     * Only available if Account Linking configuration is defined in the action package
     * and the user links their account.
     */
    open val accessToken: String?
        get() = webhookRequest.originalDetectIntentRequest?.payload?.user?.accessToken

    /**
     * True if the userVerificationStatus is VERIFIED
     * False if the userVerificationStatus is GUEST or null
     * @see <a href="https://developers.google.com/actions/assistant/save-data#determining_and_handling_user_verification_status">Assistant documentation</a>
     */
    open val isUserVerified: Boolean
        get() = webhookRequest.originalDetectIntentRequest?.payload?.user?.userVerificationStatus == "VERIFIED"

    /**
     *  Returns an [DialogflowResponseBuilder] which can be used to construct a complete webhook response
     *  containing speech and visual components.
     */
    open val responseBuilder
        get() = DialogflowResponseBuilder(this)

    /**
     * The language that was triggered during intent detection.
     */
    open val languageCode
        get() = webhookRequest.queryResult?.languageCode

    /**
     * Returns the fulfillmentText defined in Dialogflow if present.
     */
    open val fulfillmentText
        get() = webhookRequest.queryResult?.fulfillmentText

    /**
     * Return the fulfillmentMessages defined in Dialogflow if present.
     */
    open val fulfillmentMessages
        get() = webhookRequest.queryResult?.fulfillmentMessages

    /**
     * Returns the confidence score for the intent detection.
     */
    open val intentDetectionConfidence
        get() = webhookRequest.queryResult?.intentDetectionConfidence

    /**
     * Returns the confidence score for the speech recognition.
     */
    open val speechRecognitionConfidence
        get() = webhookRequest.queryResult?.speechRecognitionConfidence

    /**
     * Returns the [org.rewedigital.dialog.model.google.Input.RawInput.InputType] of the user input.
     */
    open val inputType
        get() = webhookRequest.originalDetectIntentRequest?.payload?.inputs?.firstOrNull()?.rawInputs?.firstOrNull()?.inputType

    /**
     * The collection of extracted entities.
     */
    open val arguments: Map<String, Any> = webhookRequest.queryResult?.parameters.orEmpty()

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

    /**
     * Get Location, if present.
     */
    fun getUserLocation() = webhookRequest.originalDetectIntentRequest?.payload?.device?.location

    private fun fromJson(serializedValue: String?): Map<String, Any> {
        if (serializedValue != null && serializedValue.isNotEmpty()) {
            val gson = Gson()
            try {
                val map: Map<String, Any> = gson.fromJson(
                    serializedValue,
                    object : TypeToken<Map<String, Any>>() {}.type
                )
                // NOTE: The format of the opaque string is:
                // keyValueData: {key:value; key:value; }
                if (map["data"] != null) {
                    @Suppress("UNCHECKED_CAST")
                    return map["data"] as Map<String, Any>
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
        return HashMap()
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

    /**
     * Make the [DialogflowHandler] mutable for modifying requests.
     */
    fun toMutableDialogflowHandler() = MutableDialogflowHandler(this, webhookRequest)
}