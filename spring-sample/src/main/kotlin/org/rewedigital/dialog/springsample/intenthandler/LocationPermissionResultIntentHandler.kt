package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.IntentHandler
import java.util.*


@IntentHandler
class LocationPermissionResultIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) = false

    override fun handleAlexa(input: HandlerInput): Optional<Response> = Optional.empty()

    override fun canHandleDialogflowIntent(handler: DialogflowHandler) =
        handler.action?.equals("input.location_permission.result") ?: false

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val speech = when (handler.languageCode) {
            "de" ->
                if (handler.permissionGranted())
                    "Danke, dass ich deinen Standort verwenden darf."
                else
                    "Schade, dass ich deinen Standort nicht verwenden darf."
            "en" ->
                if (handler.permissionGranted())
                    "Thank you for sharing your location."
                else
                    "Too bad I can not use your location."
            else -> ""
        }

        return handler
            .responseBuilder
            .withText(speech)
            .expectUserResponse(false)
    }
}