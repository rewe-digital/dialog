package org.rewedigital.dialog.model.dialogflow

data class WebhookResponse(
    var fulfillmentText: String? = null,
    var fulfillmentMessages: MutableList<Messages> = mutableListOf(),
    var source: String? = null,
    var payload: Payload? = null,
    var outputContexts: MutableList<OutputContext> = mutableListOf(),
    var followupEventInput: FollowupEventInput? = null
)
