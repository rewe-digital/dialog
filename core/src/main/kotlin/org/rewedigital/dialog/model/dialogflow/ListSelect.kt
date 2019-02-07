package org.rewedigital.dialog.model.dialogflow

data class ListSelect(
    val title: String? = null,
    val items: MutableList<Item> = mutableListOf()
)