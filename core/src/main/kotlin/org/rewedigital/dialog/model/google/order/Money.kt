package org.rewedigital.dialog.model.google.order

data class Money(
    var currencyCode: String? = null,
    var nanos: String? = null,
    var units: Int? = null
)