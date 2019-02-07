package org.rewedigital.dialog.model.dialogflow

data class WebhookRequest(
    val responseId: String? = null,
    val session: String? = null,
    val queryResult: QueryResult? = null,
    val originalDetectIntentRequest: OriginalDetectIntentRequest? = null
)