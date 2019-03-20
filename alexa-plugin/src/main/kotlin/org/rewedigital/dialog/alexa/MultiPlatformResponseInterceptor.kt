package org.rewedigital.dialog.alexa

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.rewedigital.dialog.interceptors.ResponseInterceptor
import java.util.*


interface MultiPlatformResponseInterceptor : ResponseInterceptor,
    com.amazon.ask.dispatcher.request.interceptor.ResponseInterceptor {

    override fun process(input: HandlerInput, response: Optional<Response>) = onAlexaResponse(input, response)

    fun onAlexaResponse(input: HandlerInput, response: Optional<Response>)
}