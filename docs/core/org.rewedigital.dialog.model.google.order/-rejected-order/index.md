[core](../../index.md) / [org.rewedigital.dialog.model.google.order](../index.md) / [RejectedOrder](./index.md)

# RejectedOrder

`data class RejectedOrder : `[`OrderUpdate`](../-order-update/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RejectedOrder(googleOrderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, actionOrderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, orderState: `[`OrderState`](../-order-state/index.md)`? = null, orderManagementActions: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`OrderAction`](../-order-action/index.md)`> = mutableListOf(), receipt: `[`Receipt`](../-receipt/index.md)`? = null, updateTime: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, totalPrice: `[`Price`](../-price/index.md)`? = null, lineItemUpdates: `[`LineItemUpdate`](../-line-item-update/index.md)`? = null, userNotification: `[`UserNotification`](../-user-notification/index.md)`? = null, infoExtension: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = emptyMap(), rejectionInfo: `[`RejectionInfo`](../-rejection-info/index.md)`? = null)` |

### Properties

| Name | Summary |
|---|---|
| [actionOrderId](action-order-id.md) | `var actionOrderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [googleOrderId](google-order-id.md) | `var googleOrderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [infoExtension](info-extension.md) | `var infoExtension: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [lineItemUpdates](line-item-updates.md) | `var lineItemUpdates: `[`LineItemUpdate`](../-line-item-update/index.md)`?` |
| [orderManagementActions](order-management-actions.md) | `var orderManagementActions: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`OrderAction`](../-order-action/index.md)`>` |
| [orderState](order-state.md) | `var orderState: `[`OrderState`](../-order-state/index.md)`?` |
| [receipt](receipt.md) | `var receipt: `[`Receipt`](../-receipt/index.md)`?` |
| [rejectionInfo](rejection-info.md) | `var rejectionInfo: `[`RejectionInfo`](../-rejection-info/index.md)`?` |
| [totalPrice](total-price.md) | `var totalPrice: `[`Price`](../-price/index.md)`?` |
| [updateTime](update-time.md) | `var updateTime: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [userNotification](user-notification.md) | `var userNotification: `[`UserNotification`](../-user-notification/index.md)`?` |
