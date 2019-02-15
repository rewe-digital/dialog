package org.rewedigital.dialog.alexa

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import org.rewedigital.dialog.handler.DialogflowIntentHandler
import java.util.*


interface MultiPlatformIntentHandler : DialogflowIntentHandler, RequestHandler {

    override fun canHandle(input: HandlerInput) = canHandleAlexa(input)

    override fun handle(input: HandlerInput) = handleAlexa(input)

    fun canHandleAlexa(input: HandlerInput): Boolean

    fun handleAlexa(input: HandlerInput): Optional<Response>
}