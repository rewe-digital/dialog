package org.rewedigital.dialog.interceptors

import org.rewedigital.dialog.model.dialogflow.WebhookRequest
import org.rewedigital.dialog.model.dialogflow.WebhookResponse

/**
 * Indicates an interceptor for outgoing requests. This class will be called from
 * the [org.rewedigital.dialog.resolver.RequestResolver].
 *
 * Maybe used for tracking or logging.
 */
interface ResponseInterceptor {

    fun onDialogflowResponse(webhookRequest: WebhookRequest, webhookResponse: WebhookResponse) {

    }
}