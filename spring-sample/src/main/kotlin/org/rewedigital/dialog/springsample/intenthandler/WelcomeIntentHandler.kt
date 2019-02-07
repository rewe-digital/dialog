package org.rewedigital.dialog.springsample.intenthandler

import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowIntentHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.IntentHandler
import org.rewedigital.dialog.ssml.Emphasis
import org.rewedigital.dialog.ssml.SsmlBuilder
import org.rewedigital.dialog.utils.withGoogleSimpleResponse


@IntentHandler
class WelcomeIntentHandler : DialogflowIntentHandler {

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.action?.equals("input.welcome") ?: false
    }

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val ssmlBuilder = SsmlBuilder()
        when (handler.languageCode) {
            "de" -> ssmlBuilder
                .appendText("Willkommen bei deinem ")
                .appendEmphasis(Emphasis.STRONG, "Demo Assistenten. ")
                .appendAudio("https://actions.google.com/sounds/v1/alarms/beep_short.ogg")
                .appendBreak()
                .appendSlowText("Wie kann ich dir helfen?")
            "en" -> ssmlBuilder
                .appendText("Welcome to your ")
                .appendEmphasis(Emphasis.STRONG, "Demo Assistant. ")
                .appendAudio("https://actions.google.com/sounds/v1/alarms/beep_short.ogg")
                .appendBreak()
                .appendSlowText("How can I help?")
        }

        val suggestions = when (handler.languageCode) {
            "de" -> arrayOf("Login", "Standort", "UI Elemente")
            "en" -> arrayOf("Login", "Location", "UI Elements")
            else -> null
        }

        return handler.responseBuilder
            .expectUserResponse(true)
            .withGoogleSimpleResponse(ssmlBuilder)
            .withGoogleSuggestions(*suggestions.orEmpty())
    }
}