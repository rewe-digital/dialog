package org.rewedigital.dialog.springsample.intenthandler

import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowIntentHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.google.GoogleBasicCard
import org.rewedigital.dialog.model.google.GoogleButton
import org.rewedigital.dialog.model.google.OpenUrlAction
import org.rewedigital.dialog.spring.annotations.IntentHandler


@IntentHandler
class UiElementsIntentHandler : DialogflowIntentHandler {

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.action?.equals("input.ui_elements") ?: false
    }

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