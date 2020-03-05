package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.IntentHandler
import java.util.*


@IntentHandler
class SelectedListItemIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) = false

    override fun handleAlexa(input: HandlerInput): Optional<Response> = Optional.empty()

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.selectedOption().isNullOrEmpty().not() &&
                handler.getContext("default-context")?.parameters?.get("LAST_INTENT_HANDLER") ==
                ListIntentHandler::class.java.simpleName
    }

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder? {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val selectedItem = handler.selectedOption()

        return handler.responseBuilder
            .withGoogleSimpleResponse("You clicked on $selectedItem.")
            .withGoogleSimpleResponse("What do you want to do now?")
            .expectUserResponse(true)
    }
}