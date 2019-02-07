package org.rewedigital.dialog.model.dialogflow

data class Card(
    val title: String? = null,
    val subtitle: String? = null,
    val imageUri: String? = null,
    val buttons: MutableList<Button> = mutableListOf()
)