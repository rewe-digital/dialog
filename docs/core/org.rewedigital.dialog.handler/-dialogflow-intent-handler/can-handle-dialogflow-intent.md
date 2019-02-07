[core](../../index.md) / [org.rewedigital.dialog.handler](../index.md) / [DialogflowIntentHandler](index.md) / [canHandleDialogflowIntent](./can-handle-dialogflow-intent.md)

# canHandleDialogflowIntent

`abstract fun canHandleDialogflowIntent(handler: `[`DialogflowHandler`](../-dialogflow-handler/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

The [org.rewedigital.dialog.resolver.RequestResolver](../../org.rewedigital.dialog.resolver/-request-resolver/index.md) will call this function. Return true if this
[DialogflowIntentHandler](index.md) should handle the incoming request. Return false if not.

