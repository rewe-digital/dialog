package org.rewedigital.dialog.model.google.order

data class Receipt(
    var confirmedActionOrderId: String? = null,
    var userVisibleOrderId: String? = null
)