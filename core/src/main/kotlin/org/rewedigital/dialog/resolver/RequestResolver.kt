package org.rewedigital.dialog.resolver

import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowIntentHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.interceptors.RequestInterceptor
import org.rewedigital.dialog.interceptors.ResponseInterceptor
import org.rewedigital.dialog.model.dialogflow.WebhookRequest
import org.rewedigital.dialog.model.dialogflow.WebhookResponse

/**
 *  [RequestResolver] handles incoming [WebhookRequest], the [DialogflowIntentHandler.canHandleDialogflowIntent]
 *  from all given [DialogflowIntentHandler] will be called to figure out witch [DialogflowIntentHandler]
 *  can handle the incoming [WebhookRequest].
 *
 *  The first [DialogflowIntentHandler] that [DialogflowIntentHandler.canHandleDialogflowIntent] returns true
 *  will be used to handle the [WebhookRequest]. Therefor the [DialogflowIntentHandler.handleDialogflowIntent]
 *  function will be called.
 *
 *  If there is no matching [DialogflowIntentHandler] the [fallbackAction] will be triggered.
 *
 *  It's possible to provide [RequestInterceptor] and [ResponseInterceptor], they will be triggered for every
 *  incoming [WebhookRequest] and outgoing [WebhookResponse].
 */
class RequestResolver(
    private val intentHandlers: List<DialogflowIntentHandler>,
    private val requestInterceptors: List<RequestInterceptor>,
    private val responseInterceptors: List<ResponseInterceptor>,
    private val fallbackAction: (DialogflowHandler) -> DialogflowResponseBuilder?
) {
    fun resolveRequest(webhookRequest: WebhookRequest): WebhookResponse? {

        requestInterceptors.forEach {
            it.onDialogflowRequest(webhookRequest)
        }

        return DialogflowHandler(webhookRequest)
            .run {
                (intentHandlers
                    .firstOrNull {
                        it.canHandleDialogflowIntent(this)
                    }
                    ?.let {
                        it.handleDialogflowIntent(this)
                    } ?: fallbackAction(this))
                    ?.build()
                    ?.also { response ->
                        responseInterceptors.forEach {
                            it.onDialogflowResponse(webhookRequest, response)
                        }
                    }
            }
    }
}