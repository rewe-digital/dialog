package org.rewedigital.dialog.model.google.order

data class LineItemUpdate(
    var orderState: OrderState? = null,
    var price: Price? = null,
    var reason: String? = null,
    var extensions: Map<String, String> = emptyMap()
)
