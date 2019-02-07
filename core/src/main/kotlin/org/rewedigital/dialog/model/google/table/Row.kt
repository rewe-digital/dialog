package org.rewedigital.dialog.model.google.table

data class Row(
    var cells: MutableList<Cell> = mutableListOf(),
    var dividerAfter: Boolean
)