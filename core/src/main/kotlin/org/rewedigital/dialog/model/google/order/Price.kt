package org.rewedigital.dialog.model.google.order

data class Price(
    var type: PriceType,
    var amount: Money
)