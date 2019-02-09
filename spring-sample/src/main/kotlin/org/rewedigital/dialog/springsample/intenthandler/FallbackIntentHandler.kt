package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.FallbackIntentHandler
import java.util.*

@FallbackIntentHandler
class FallbackIntentHandler : MultiPlatformIntentHandler {

    override fun canHandle(input: HandlerInput?): Boolean {
        return false
    }

    override fun handle(input: HandlerInput?): Optional<Response> {
        return Optional.empty()
    }

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return false
    }

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        return handler.responseBuilder.withText("Fallback!!!")
    }
}