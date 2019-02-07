package org.rewedigital.dialog.interceptors

import org.rewedigital.dialog.model.dialogflow.WebhookRequest

/**
 * Indicates an interceptor for incoming requests. This class will be called from
 * the [org.rewedigital.dialog.resolver.RequestResolver].
 *
 * Maybe used for tracking or logging.
 */
interface RequestInterceptor {

    fun onDialogflowRequest(webhookRequest: WebhookRequest) {

    }
}