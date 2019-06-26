package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.google.Status
import org.rewedigital.dialog.spring.annotations.IntentHandler
import java.util.*


@IntentHandler
class SignInResultIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) = false

    override fun handleAlexa(input: HandlerInput): Optional<Response> = Optional.empty()

    override fun canHandleDialogflowIntent(handler: DialogflowHandler) =
        handler.action?.equals("input.sign_in.result") ?: false

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val speech = when (handler.signInStatus()) {
            Status.SignIn.OK -> "SignIn OK"
            Status.SignIn.CANCELLED -> "SignIn Cancelled"
            else -> "SignIn Error"
        }

        return handler.responseBuilder
            .expectUserResponse(false)
            .withGoogleSimpleResponse(speech)
    }
}