package org.rewedigital.dialog.model.dialogflow

data class QueryResult(
    val queryText: String? = null,
    val action: String? = null,
    val parameters: Map<String, Any> = emptyMap(),
    val allRequiredParamsPresent: Boolean = false,
    val fulfillmentText: String? = null,
    val fulfillmentMessages: MutableList<Messages> = mutableListOf(),
    val outputContexts: MutableList<OutputContext> = mutableListOf(),
    val intent: Intent? = null,
    val intentDetectionConfidence: Double = 0.0,
    val speechRecognitionConfidence: Double = 0.0,
    val languageCode: String? = null,
    val diagnosticInfo: Map<String, Any> = emptyMap(),
    val webhookSource: String? = null,
    val webhookPayload: Map<String, Any> = emptyMap()
)