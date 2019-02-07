package org.rewedigital.dialog.model.google.order

import org.rewedigital.dialog.model.google.OpenUrlAction

data class OrderButton(
    var title: String? = null,
    var openUrlAction: OpenUrlAction? = null
)