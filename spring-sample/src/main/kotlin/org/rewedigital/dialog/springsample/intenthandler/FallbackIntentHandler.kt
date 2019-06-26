package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.spring.annotations.FallbackIntentHandler
import java.util.*

@FallbackIntentHandler
class FallbackIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) = false

    override fun handleAlexa(input: HandlerInput): Optional<Response> = Optional.empty()

    override fun canHandleDialogflowIntent(handler: DialogflowHandler) = false

    override fun handleDialogflowIntent(handler: DialogflowHandler) =
        handler.responseBuilder.withGoogleSimpleResponse("Fallback!!!")
}