package org.rewedigital.dialog.springsample.interceptors

import com.fasterxml.jackson.databind.ObjectMapper
import org.rewedigital.dialog.interceptors.RequestInterceptor
import org.rewedigital.dialog.interceptors.ResponseInterceptor
import org.rewedigital.dialog.model.dialogflow.WebhookRequest
import org.rewedigital.dialog.model.dialogflow.WebhookResponse
import org.rewedigital.dialog.spring.annotations.Interceptor


@Interceptor
class LoggingInterceptor(private val objectMapper: ObjectMapper) : RequestInterceptor, ResponseInterceptor {

    override fun onDialogflowRequest(webhookRequest: WebhookRequest) {
        println(objectMapper.writeValueAsString(webhookRequest))
    }

    override fun onDialogflowResponse(webhookRequest: WebhookRequest, webhookResponse: WebhookResponse) {
        println(objectMapper.writeValueAsString(webhookResponse))
    }
}