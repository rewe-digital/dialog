package org.rewedigital.dialog.model.google.order

interface OrderUpdate {
    var googleOrderId: String?
    var actionOrderId: String?
    var orderState: OrderState?
    var orderManagementActions: MutableList<OrderAction>
    var receipt: Receipt?
    var updateTime: String?
    var totalPrice: Price?
    var lineItemUpdates: LineItemUpdate?
    var userNotification: UserNotification?
    var infoExtension: Map<String, String>?
}

data class RejectedOrder(
    override var googleOrderId: String? = null,
    override var actionOrderId: String? = null,
    override var orderState: OrderState? = null,
    override var orderManagementActions: MutableList<OrderAction> = mutableListOf(),
    override var receipt: Receipt? = null,
    override var updateTime: String? = null,
    override var totalPrice: Price? = null,
    override var lineItemUpdates: LineItemUpdate? = null,
    override var userNotification: UserNotification? = null,
    override var infoExtension: Map<String, String>? = emptyMap(),
    var rejectionInfo: RejectionInfo? = null
) : OrderUpdate

data class CanceledOrder(
    override var googleOrderId: String? = null,
    override var actionOrderId: String? = null,
    override var orderState: OrderState? = null,
    override var orderManagementActions: MutableList<OrderAction> = mutableListOf(),
    override var receipt: Receipt? = null,
    override var updateTime: String? = null,
    override var totalPrice: Price? = null,
    override var lineItemUpdates: LineItemUpdate? = null,
    override var userNotification: UserNotification? = null,
    override var infoExtension: Map<String, String>? = emptyMap(),
    var cancellationInfo: Reason? = null
) : OrderUpdate

data class SentOrder(
    override var googleOrderId: String? = null,
    override var actionOrderId: String? = null,
    override var orderState: OrderState? = null,
    override var orderManagementActions: MutableList<OrderAction> = mutableListOf(),
    override var receipt: Receipt? = null,
    override var updateTime: String? = null,
    override var totalPrice: Price? = null,
    override var lineItemUpdates: LineItemUpdate? = null,
    override var userNotification: UserNotification? = null,
    override var infoExtension: Map<String, String>? = emptyMap(),
    var inTransitInfo: InTransitInfo? = null
) : OrderUpdate

data class FulfilledOrder(
    override var googleOrderId: String? = null,
    override var actionOrderId: String? = null,
    override var orderState: OrderState? = null,
    override var orderManagementActions: MutableList<OrderAction> = mutableListOf(),
    override var receipt: Receipt? = null,
    override var updateTime: String? = null,
    override var totalPrice: Price? = null,
    override var lineItemUpdates: LineItemUpdate? = null,
    override var userNotification: UserNotification? = null,
    override var infoExtension: Map<String, String>? = emptyMap(),
    var fulfillmentInfo: FulfillmentInfo? = null
) : OrderUpdate

data class ReturnedOrder(
    override var googleOrderId: String? = null,
    override var actionOrderId: String? = null,
    override var orderState: OrderState? = null,
    override var orderManagementActions: MutableList<OrderAction> = mutableListOf(),
    override var receipt: Receipt? = null,
    override var updateTime: String? = null,
    override var totalPrice: Price? = null,
    override var lineItemUpdates: LineItemUpdate? = null,
    override var userNotification: UserNotification? = null,
    override var infoExtension: Map<String, String>? = emptyMap(),
    var returnInfo: Reason? = null
) : OrderUpdate