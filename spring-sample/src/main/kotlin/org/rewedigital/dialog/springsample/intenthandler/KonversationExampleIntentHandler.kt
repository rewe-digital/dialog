package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.IntentHandler
import org.rewedigital.dialog.utils.loadKonversation
import org.rewedigital.dialog.utils.withGoogleReprompts
import org.rewedigital.dialog.utils.withGoogleSimpleResponse
import org.rewedigital.dialog.utils.withGoogleSuggestions
import java.util.*

@IntentHandler
class KonversationExampleIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) = false

    override fun handleAlexa(input: HandlerInput): Optional<Response> = Optional.empty()

    override fun canHandleDialogflowIntent(handler: DialogflowHandler) =
        handler.action?.equals("input.welcome2") ?: false

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val konversation = handler.loadKonversation("help").createOutput()

        return handler.responseBuilder
            .expectUserResponse(true)
            .withGoogleSimpleResponse(konversation)
            .withGoogleSuggestions(konversation)
            .withGoogleReprompts(konversation)
    }
}