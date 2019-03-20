package org.rewedigital.dialog.springsample.intenthandler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.alexa.MultiPlatformIntentHandler
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.google.GoogleCarouselItem
import org.rewedigital.dialog.model.google.OptionInfo
import org.rewedigital.dialog.spring.annotations.IntentHandler
import java.util.*


@IntentHandler
class MoreUiElementsIntentHandler : MultiPlatformIntentHandler {

    override fun canHandleAlexa(input: HandlerInput) = false

    override fun handleAlexa(input: HandlerInput): Optional<Response> = Optional.empty()

    override fun canHandleDialogflowIntent(handler: DialogflowHandler) =
        ((handler.action?.equals("input.more") ?: false)
                && (handler.getContextParam("default-context", "LAST_INTENT_HANDLER") as? String)
            .equals(UiElementsIntentHandler::class.java.simpleName))

    override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
        handler.setContextParam("default-context", "LAST_INTENT_HANDLER", this.javaClass.simpleName)

        val speech = when (handler.languageCode) {
            "de" -> "Ein paar mehr UI Elemente"
            "en" -> "Some more UI elements"
            else -> ""
        }

        return handler.responseBuilder
            .expectUserResponse(true)
            .withGoogleSimpleResponse(speech)
            .withGoogleCarouselSelect(
                GoogleCarouselItem(
                    title = "Standort",
                    description = "Description1",
                    optionInfo = OptionInfo("Standort")
                ),
                GoogleCarouselItem(
                    title = "Login",
                    description = "Description2",
                    optionInfo = OptionInfo("Login")
                )
            )
    }
}