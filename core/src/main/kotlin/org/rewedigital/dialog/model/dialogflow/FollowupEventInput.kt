package org.rewedigital.dialog.model.dialogflow

data class FollowupEventInput(
    val name: String? = null,
    val languageCode: String? = null,
    val parameters: Map<String, String>? = null
)