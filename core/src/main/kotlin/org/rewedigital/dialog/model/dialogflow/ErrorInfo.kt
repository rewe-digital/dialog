package org.rewedigital.dialog.model.dialogflow


data class ErrorInfo(
    val path: String? = null,
    val code: String? = null,
    val message: String? = null,
    val fieldErrors: MutableList<FieldErrorResource> = mutableListOf()
)