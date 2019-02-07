[core](../../index.md) / [org.rewedigital.dialog.model.google.order](../index.md) / [OrderUpdate](./index.md)

# OrderUpdate

`interface OrderUpdate`

### Properties

| Name | Summary |
|---|---|
| [actionOrderId](action-order-id.md) | `abstract var actionOrderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [googleOrderId](google-order-id.md) | `abstract var googleOrderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [infoExtension](info-extension.md) | `abstract var infoExtension: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [lineItemUpdates](line-item-updates.md) | `abstract var lineItemUpdates: `[`LineItemUpdate`](../-line-item-update/index.md)`?` |
| [orderManagementActions](order-management-actions.md) | `abstract var orderManagementActions: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`OrderAction`](../-order-action/index.md)`>` |
| [orderState](order-state.md) | `abstract var orderState: `[`OrderState`](../-order-state/index.md)`?` |
| [receipt](receipt.md) | `abstract var receipt: `[`Receipt`](../-receipt/index.md)`?` |
| [totalPrice](total-price.md) | `abstract var totalPrice: `[`Price`](../-price/index.md)`?` |
| [updateTime](update-time.md) | `abstract var updateTime: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [userNotification](user-notification.md) | `abstract var userNotification: `[`UserNotification`](../-user-notification/index.md)`?` |

### Inheritors

| Name | Summary |
|---|---|
| [CanceledOrder](../-canceled-order/index.md) | `data class CanceledOrder : `[`OrderUpdate`](./index.md) |
| [FulfilledOrder](../-fulfilled-order/index.md) | `data class FulfilledOrder : `[`OrderUpdate`](./index.md) |
| [RejectedOrder](../-rejected-order/index.md) | `data class RejectedOrder : `[`OrderUpdate`](./index.md) |
| [ReturnedOrder](../-returned-order/index.md) | `data class ReturnedOrder : `[`OrderUpdate`](./index.md) |
| [SentOrder](../-sent-order/index.md) | `data class SentOrder : `[`OrderUpdate`](./index.md) |
