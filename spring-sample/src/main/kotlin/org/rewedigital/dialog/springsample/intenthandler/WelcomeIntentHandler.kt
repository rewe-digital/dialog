package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.IntentHandler
import org.rewedigital.dialog.ssml.Emphasis
import org.rewedigital.dialog.ssml.SsmlBuilder
import org.rewedigital.dialog.utils.withGoogleSimpleResponse
import java.util.*


@IntentHandler
class WelcomeIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) =
        input.matches(Predicates.requestType(LaunchRequest::class.java))

    override fun handleAlexa(input: HandlerInput): Optional<Response> {
        input.attributesManager.sessionAttributes["LAST_INTENT_HANDLER"] = this.javaClass.simpleName

        val ssmlBuilder = SsmlBuilder()
        when (input.request.locale) {
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

        return input.responseBuilder
            .withShouldEndSession(false)
            .withSpeech(ssmlBuilder.asSsmlString())
            .build()
    }

    override fun canHandleDialogflowIntent(handler: DialogflowHandler) =
        handler.action?.equals("input.welcome") ?: false

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