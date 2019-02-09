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
class SignInIntentHandler : MultiPlatformIntentHandler {

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.intentName("input.sign_in"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        input.attributesManager.sessionAttributes["LAST_INTENT_HANDLER"] = this.javaClass.simpleName
        return input.responseBuilder
            .withSpeech(SsmlBuilder("Please link your Account.").asSsmlString())
            .withLinkAccountCard()
            .build()
    }

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.action?.equals("input.sign_in") ?: false
    }

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)
        return handler.responseBuilder.askGoogleForSignIn()
    }
}