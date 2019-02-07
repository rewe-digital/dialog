package org.rewedigital.dialog.model.google.order

data class OrderAction(
    var type: OrderUpdateActionType? = OrderUpdateActionType.UNKNOWN,
    var button: OrderButton? = null
)