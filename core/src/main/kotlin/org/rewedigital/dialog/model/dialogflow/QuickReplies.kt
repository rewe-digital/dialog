package org.rewedigital.dialog.model.dialogflow

data class QuickReplies(
    val title: String? = null,
    val quickReplies: MutableList<String> = mutableListOf()
)