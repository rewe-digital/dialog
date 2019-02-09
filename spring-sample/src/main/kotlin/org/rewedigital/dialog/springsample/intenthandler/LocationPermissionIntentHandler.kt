package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.IntentHandler
import org.rewedigital.dialog.ssml.SsmlBuilder
import java.util.*


@IntentHandler
class LocationPermissionIntentHandler : MultiPlatformIntentHandler {

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.intentName("input.location_permission"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        return input.responseBuilder
            .withSpeech(SsmlBuilder("To use this feature we need your permission.").asSsmlString())
            .withAskForPermissionsConsentCard(listOf("read::alexa:device:all:address"))
            .build()
    }

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.action?.equals("input.location_permission") ?: false
    }

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val reason = when (handler.languageCode) {
            "de" -> "Um dir Orte in deiner Nähe zu zeigen"
            "en" -> "To show you places around you"
            else -> ""
        }

        return handler.responseBuilder.askGoogleForLocation(reason)
    }
}