package org.rewedigital.dialog.model.google

import org.rewedigital.dialog.model.dialogflow.ListSelect


data class GoogleListSelect(
    var items: List<GoogleListItem> = listOf(),
    var title: String? = null
) {
    fun toDialogflowModel() = ListSelect(items = items.map { it.toDialogflowModel() }.toMutableList(), title = title)
}