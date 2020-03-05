package org.rewedigital.dialog.handler

import com.google.gson.Gson
import org.rewedigital.dialog.extensions.validate
import org.rewedigital.dialog.factories.SystemIntentFactory
import org.rewedigital.dialog.model.dialogflow.*
import org.rewedigital.dialog.model.google.*


class DialogflowResponseBuilder(private val dialogflowHandler: DialogflowHandler) {

    private val response = WebhookResponse()

    private fun WebhookResponse.getOrCreatePayload() =
        payload ?: Payload(
            google = GooglePayload(
                richResponse = RichResponse()
            )
        ).also { newPayload ->
            payload = newPayload
        }

    /**
     * Set the FulfillmentText for Dialogflow.
     */
    fun withText(text: String) = apply {
        response.fulfillmentText = text
    }

    /**
     * Adds the given [Messages] list to the current one.
     */
    fun withMessages(messages: List<Messages>) = apply {
        response.fulfillmentMessages.addAll(messages)
    }

    /**
     * Adds a [TextMessage] with the given [Platform].
     */
    fun withTextMessage(text: TextMessage, platform: Platform? = null) = apply {
        response
            .fulfillmentMessages
            .add(Messages(platform = platform, text = text))
    }

    /**
     * Adds a [TextMessage] with a list of a given string and [Platform].
     */
    fun withTextMessage(vararg text: String, platform: Platform? = null) = apply {
        response
            .fulfillmentMessages
            .add(Messages(platform = platform, text = TextMessage(text.toMutableList())))
    }

    /**
     * Adds an [Image] for the given [Platform].
     */
    fun withImage(image: Image, platform: Platform? = null) = apply {
        response
            .fulfillmentMessages
            .add(Messages(platform = platform, image = image))
    }

    /**
     * Adds [QuickReplies] for the given [Platform].
     */
    fun withQuickReplies(quickReplies: QuickReplies, platform: Platform? = null) = apply {
        response
            .fulfillmentMessages
            .add(Messages(platform = platform, quickReplies = quickReplies))
    }

    /**
     * Adds a [Card] for the given [Platform].
     */
    fun withCard(card: Card, platform: Platform? = null) = apply {
        response
            .fulfillmentMessages
            .add(Messages(platform = platform, card = card))
    }

    /**
     * Adds [GoogleSimpleResponses]. [RichResponse] must start with a [GoogleSimpleResponse].
     * A maximum of two [GoogleSimpleResponse] per [RichResponse] are allowed.
     */
    fun withGoogleSimpleResponses(simpleResponses: GoogleSimpleResponses) = apply {
        response.getOrCreatePayload().google?.richResponse?.items?.let { items ->
            simpleResponses.simpleResponses.forEach { simpleResponse ->
                items += SimpleResponseHolder(simpleResponse)
            }
        }
    }

    /**
     * Adds a [GoogleSimpleResponse]. [RichResponse] must start with a [GoogleSimpleResponse].
     * A maximum of two [GoogleSimpleResponse] per [RichResponse] are allowed.
     */
    fun withGoogleSimpleResponse(simpleResponse: GoogleSimpleResponse) = apply {
        response.getOrCreatePayload().google?.richResponse?.items?.let { items ->
            items += SimpleResponseHolder(simpleResponse)
        }
    }

    /**
     * Adds a [GoogleSimpleResponse] with the given string. [RichResponse] must start with a [GoogleSimpleResponse].
     * A maximum of two [GoogleSimpleResponse] per [RichResponse] are allowed.
     */
    fun withGoogleSimpleResponse(simpleResponse: String) = apply {
        response.getOrCreatePayload().google?.richResponse?.withSimpleResponse(simpleResponse)
    }

    /**
     * Adds a [GoogleBasicCard]. [RichResponse] must start with a [GoogleSimpleResponse].
     * Only one [GoogleBasicCard] per [RichResponse] is allowed.
     */
    fun withGoogleBasicCard(basicCard: GoogleBasicCard) = apply {
        response.getOrCreatePayload().google?.richResponse?.items?.add(BasicCardHolder(basicCard))
    }

    /**
     * Adds a [GoogleBasicCard]. [RichResponse] must start with a [GoogleSimpleResponse].
     * Only one [GoogleBasicCard] per [RichResponse] is allowed.
     */
    fun withGoogleBasicCard(
        title: String,
        subtitle: String? = null,
        formattedText: String? = null,
        image: GoogleImage? = null,
        buttons: MutableList<GoogleButton> = mutableListOf(),
        imageDisplayOptions: ImageDisplayOptions? = ImageDisplayOptions.CROPPED
    ) = apply {
        val basicCard = GoogleBasicCard(
            title = title,
            subtitle = subtitle,
            formattedText = formattedText,
            image = image,
            buttons = buttons,
            imageDisplayOptions = imageDisplayOptions
        )
        response.getOrCreatePayload().google?.richResponse?.items?.add(BasicCardHolder(basicCard))
    }

    /**
     * Adds [Suggestions].
     */
    fun withGoogleSuggestions(suggestions: Suggestions) = apply {
        response.getOrCreatePayload().google?.richResponse?.suggestions?.addAll(suggestions.suggestions)
    }

    /**
     * Adds [Suggestions] with the given strings.
     */
    fun withGoogleSuggestions(vararg suggestions: String) = apply {
        val suggestionList = suggestions.map(::Suggestion).toMutableList()
        response.getOrCreatePayload().google?.richResponse?.suggestions?.addAll(suggestionList)
    }

    /**
     * Adds [LinkOutSuggestion].
     */
    fun withGoogleLinkOutSuggestion(linkOutSuggestion: LinkOutSuggestion) = apply {
        response.getOrCreatePayload().google?.richResponse?.linkOutSuggestion?.add(linkOutSuggestion)
    }

    /**
     * Adds a [ListSelect].
     */
    fun withListSelect(listSelect: ListSelect) = apply {
        response
            .fulfillmentMessages
            .add(Messages(platform = Platform.ACTIONS_ON_GOOGLE, listSelect = listSelect))
    }

    /**
     * Adds a [GoogleCarouselSelect] with the given [GoogleCarouselItem]. In addition there must be at least one
     * [RichResponse] item.
     */
    fun withGoogleCarouselSelect(vararg carouselItems: GoogleCarouselItem) = apply {
        response.getOrCreatePayload().google?.systemIntent = SystemIntent.createCarouselSelect(*carouselItems)
    }

    /**
     * Adds a [GoogleListSelect] with the given [GoogleListItem]. In addition there must be at least one
     * [RichResponse] item.
     * [GoogleListSelect] needs at least two [GoogleListItem].
     */
    fun withGoogleSelectionList(vararg items: GoogleListItem, title: String? = null) = apply {
        response.getOrCreatePayload().google?.systemIntent =
            SystemIntent.createListSelect(items = *items, title = title)
    }

    /**
     * Adds a list of reprompts.
     */
    fun withGoogleReprompts(vararg repropmpts: String) = apply {
        response.getOrCreatePayload()
            .google?.noInputPrompts?.addAll(repropmpts.map { GoogleSimpleResponse(textToSpeech = it) })
    }

    /**
     * Adds a list of [GoogleSimpleResponse] as reprompts.
     */
    fun withGoogleReprompts(vararg repropmpts: GoogleSimpleResponse) = apply {
        response.getOrCreatePayload().google?.noInputPrompts?.addAll(repropmpts)
    }

    /**
     * Helper function to ask the user to start the sign-in process. [DialogflowHandler.signInStatus] will return the
     * result of the sign-in process.
     */
    fun askGoogleForSignIn(reason: String? = null) = apply {
        response.payload = Payload(
            GooglePayload(
                text = "PLACEHOLDER",
                expectUserResponse = true,
                systemIntent = SystemIntentFactory.buildSignInIntent(reason)
            )
        )
    }

    /**
     * Helper function to ask the user for [Permissions.DEVICE_PRECISE_LOCATION] permission.
     * [DialogflowHandler.permissionGranted] will return true if the permission was granted.
     */
    fun askGoogleForPreciseLocation(reason: String) = apply {
        response.payload = Payload(
            GooglePayload(
                expectUserResponse = true,
                systemIntent = SystemIntentFactory.buildPermissionIntent(reason, Permissions.DEVICE_PRECISE_LOCATION)
            )
        )
    }

    /**
     * Helper function to ask the user for [Permissions.DEVICE_COARSE_LOCATION] permission.
     * [DialogflowHandler.permissionGranted] will return true if the permission was granted.
     */
    fun askGoogleForCoarseLocation(reason: String) = apply {
        response.payload = Payload(
            GooglePayload(
                expectUserResponse = true,
                systemIntent = SystemIntentFactory.buildPermissionIntent(reason, Permissions.DEVICE_COARSE_LOCATION)
            )
        )
    }

    /**
     * Helper function to ask the user for [Permissions.DEVICE_COARSE_LOCATION] and
     * [Permissions.DEVICE_PRECISE_LOCATION] permission.
     * [DialogflowHandler.permissionGranted] will return true if the permission was granted.
     */
    fun askGoogleForLocation(reason: String) = apply {
        response.payload = Payload(
            GooglePayload(
                expectUserResponse = true,
                systemIntent = SystemIntentFactory.buildPermissionIntent(
                    reason,
                    Permissions.DEVICE_COARSE_LOCATION,
                    Permissions.DEVICE_PRECISE_LOCATION
                )
            )
        )
    }

    /**
     * Set this true if the agent awaits a response from the user or false if the agent should close the session.
     */
    fun expectUserResponse(expectResponse: Boolean) = apply {
        response.getOrCreatePayload().google?.expectUserResponse = expectResponse
    }

    /**
     * Returns the [WebhookResponse] and [WebhookResponse.validate] the result.
     */
    fun build(): WebhookResponse =
        response
            .apply {
                source = "Webhook"
                outputContexts = dialogflowHandler.getContextList().toMutableList()
                getOrCreatePayload().google?.userStorage = run {
                    val dataMap = HashMap<String, Any?>()
                    dataMap["data"] = dialogflowHandler.userData
                    Gson().toJson(dataMap)
                }

                // Remove RichResponse if there are no items in it
                if (payload?.google?.richResponse?.items?.isEmpty() == true) {
                    payload?.google?.richResponse = null
                }
            }
            .validate()

    companion object {
        // Hidden feature for plugin development
        fun getRequestOf(responseBuilder: DialogflowResponseBuilder) = responseBuilder.dialogflowHandler
    }
}