package org.rewedigital.dialog.springsample.intenthandler

import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowIntentHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.IntentHandler


@IntentHandler
class LocationPermissionResultIntentHandler : DialogflowIntentHandler {

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.action?.equals("input.location_permission.result") ?: false
    }

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