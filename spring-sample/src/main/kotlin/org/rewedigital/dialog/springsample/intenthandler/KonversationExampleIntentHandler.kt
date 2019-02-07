package org.rewedigital.dialog.springsample.intenthandler

import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowIntentHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.spring.annotations.IntentHandler
import org.rewedigital.dialog.utils.loadKonversation
import org.rewedigital.dialog.utils.withGoogleReprompts
import org.rewedigital.dialog.utils.withGoogleSimpleResponse
import org.rewedigital.dialog.utils.withGoogleSuggestions

@IntentHandler
class KonversationExampleIntentHandler : DialogflowIntentHandler {

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.action?.equals("input.welcome2") ?: false
    }

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