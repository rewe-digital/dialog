package org.rewedigital.dialog.model.dialogflow

data class OutputContext(
    val name: String? = null,
    val lifespanCount: Int = 0,
    val parameters: DialogflowParams? = null
)