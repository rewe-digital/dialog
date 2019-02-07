package org.rewedigital.dialog.springsample.intenthandler

import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowIntentHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.google.Status
import org.rewedigital.dialog.spring.annotations.IntentHandler


@IntentHandler
class SignInResultIntentHandler : DialogflowIntentHandler {

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.action?.equals("input.sign_in.result") ?: false
    }

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val speech = when (handler.signInStatus()) {
            Status.SignIn.OK -> "SignIn OK"
            Status.SignIn.CANCELLED -> "SignIn Cancelled"
            else -> "SignIn Error"
        }

        return handler.responseBuilder
            .expectUserResponse(false)
            .withText(speech)
    }
}