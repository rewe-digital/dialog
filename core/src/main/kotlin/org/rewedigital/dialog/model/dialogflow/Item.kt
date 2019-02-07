package org.rewedigital.dialog.model.dialogflow

data class Item(
    val info: SelectItemInfo? = null,
    val title: String? = null,
    val description: String? = null,
    val image: Image? = null
)