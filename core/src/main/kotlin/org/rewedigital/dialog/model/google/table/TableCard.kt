package org.rewedigital.dialog.model.google.table

import org.rewedigital.dialog.model.dialogflow.Button
import org.rewedigital.dialog.model.dialogflow.Image

data class TableCard(
    var title: String? = null,
    var subtitle: String? = null,
    var image: Image? = null,
    var columnProperties: MutableList<ColumnProperties> = mutableListOf(),
    var rows: MutableList<Row> = mutableListOf(),
    var buttons: MutableList<Button> = mutableListOf()
)