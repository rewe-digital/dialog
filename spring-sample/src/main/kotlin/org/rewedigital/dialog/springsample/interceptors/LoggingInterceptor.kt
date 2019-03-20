package org.rewedigital.dialog.springsample.interceptors

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import com.fasterxml.jackson.databind.ObjectMapper
import org.rewedigital.dialog.alexa.MultiPlatformRequestInterceptor
import org.rewedigital.dialog.alexa.MultiPlatformResponseInterceptor
import org.rewedigital.dialog.model.dialogflow.WebhookRequest
import org.rewedigital.dialog.model.dialogflow.WebhookResponse
import org.rewedigital.dialog.spring.annotations.Interceptor
import java.util.*


@Interceptor
class LoggingInterceptor(private val objectMapper: ObjectMapper) :
    MultiPlatformRequestInterceptor,
    MultiPlatformResponseInterceptor {

    override fun onAlexaRequest(input: HandlerInput) {
        println(input.requestEnvelope.toString())
    }

    override fun onAlexaResponse(input: HandlerInput, response: Optional<Response>) {
        response.ifPresent {
            println(it.toString())
        }
    }

    override fun onDialogflowRequest(webhookRequest: WebhookRequest) {
        println(objectMapper.writeValueAsString(webhookRequest))
    }

    override fun onDialogflowResponse(webhookRequest: WebhookRequest, webhookResponse: WebhookResponse) {
        println(objectMapper.writeValueAsString(webhookResponse))
    }
}