package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.google.GoogleButton
import org.rewedigital.dialog.model.google.OpenUrlAction
import org.rewedigital.dialog.spring.annotations.IntentHandler
import java.util.*


@IntentHandler
class UiElementsIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) = false

    override fun handleAlexa(input: HandlerInput): Optional<Response> = Optional.empty()

    override fun canHandleDialogflowIntent(handler: DialogflowHandler) =
        handler.action?.equals("input.ui_elements") ?: false

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val speech = when (handler.languageCode) {
            "de" -> "Ein paar UI Elemente"
            "en" -> "Some UI elements"
            else -> ""
        }

        val question = when (handler.languageCode) {
            "de" -> "Möchtest du mehr?"
            "en" -> "Do you want some more?"
            else -> ""
        }

        val suggestions = when (handler.languageCode) {
            "de" -> arrayOf("Mehr")
            "en" -> arrayOf("More")
            else -> null
        }

        return handler.responseBuilder
            .expectUserResponse(true)
            .withGoogleSimpleResponse(speech)
            .withGoogleBasicCard(
                title = "CardTitle",
                subtitle = "CardSubTitle",
                formattedText = "CardFormattedText",
                buttons = mutableListOf(
                    GoogleButton(
                        title = "ButtonText",
                        openUrlAction = OpenUrlAction(url = "https://rewe-digital.com/")
                    )
                )
            )
            .withGoogleSimpleResponse(question)
            .withGoogleSuggestions(*suggestions.orEmpty())
    }
}