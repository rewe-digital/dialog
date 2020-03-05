package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.dialogflow.OptionInfo
import org.rewedigital.dialog.model.google.GoogleListItem
import org.rewedigital.dialog.spring.annotations.IntentHandler
import java.util.*

@IntentHandler
class ListIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) = false

    override fun handleAlexa(input: HandlerInput): Optional<Response> = Optional.empty()

    override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
        return handler.action?.equals("list_response") ?: false
    }

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder? {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        return handler.responseBuilder
            .withGoogleSimpleResponse("Here is your list.")
            .withGoogleSelectionList(
                GoogleListItem(title = "Cheese", optionInfo = OptionInfo("Cheese")),
                GoogleListItem(title = "Ham", optionInfo = OptionInfo("Ham")),
                GoogleListItem(title = "Milk", optionInfo = OptionInfo("Milk")),
                GoogleListItem(title = "Beans", optionInfo = OptionInfo("Beans")),
                GoogleListItem(title = "Bread", optionInfo = OptionInfo("Bread")),
                title = "My shopping list"
            )
            .withGoogleSimpleResponse("What do you want to do now?")
            .expectUserResponse(true)
    }
}