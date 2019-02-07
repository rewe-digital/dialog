package org.rewedigital.dialog.model.dialogflow

data class SelectItemInfo(
    val key: String? = null,
    val synonyms: MutableList<String> = mutableListOf()
)