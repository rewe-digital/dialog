package org.rewedigital.dialog.alexa

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import org.rewedigital.dialog.interceptors.RequestInterceptor


interface MultiPlatformRequestInterceptor : RequestInterceptor,
    com.amazon.ask.dispatcher.request.interceptor.RequestInterceptor {

    override fun process(input: HandlerInput) = onAlexaRequest(input)

    fun onAlexaRequest(input: HandlerInput)
}