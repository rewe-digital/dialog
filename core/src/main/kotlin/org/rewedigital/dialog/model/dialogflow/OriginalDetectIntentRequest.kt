package org.rewedigital.dialog.model.dialogflow

import org.rewedigital.dialog.model.google.AppRequest

data class OriginalDetectIntentRequest(
    val source: String? = null,
    val version: String? = null,
    val payload: AppRequest? = null
)