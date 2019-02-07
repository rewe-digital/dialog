[core](../../index.md) / [org.rewedigital.dialog.handler](../index.md) / [DialogflowIntentHandler](./index.md)

# DialogflowIntentHandler

`interface DialogflowIntentHandler`

Indicates that the class which implements the [DialogflowIntentHandler](./index.md) can handle an Intent from
Dialogflow.

The [DialogflowIntentHandler](./index.md) will be called from the [org.rewedigital.dialog.resolver.RequestResolver](../../org.rewedigital.dialog.resolver/-request-resolver/index.md).

### Functions

| Name | Summary |
|---|---|
| [canHandleDialogflowIntent](can-handle-dialogflow-intent.md) | `abstract fun canHandleDialogflowIntent(handler: `[`DialogflowHandler`](../-dialogflow-handler/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The [org.rewedigital.dialog.resolver.RequestResolver](../../org.rewedigital.dialog.resolver/-request-resolver/index.md) will call this function. Return true if this [DialogflowIntentHandler](./index.md) should handle the incoming request. Return false if not. |
| [handleDialogflowIntent](handle-dialogflow-intent.md) | `abstract fun handleDialogflowIntent(handler: `[`DialogflowHandler`](../-dialogflow-handler/index.md)`): `[`DialogflowResponseBuilder`](../-dialogflow-response-builder/index.md)`?`<br>The [org.rewedigital.dialog.resolver.RequestResolver](../../org.rewedigital.dialog.resolver/-request-resolver/index.md) will call this function if the [canHandleDialogflowIntent](can-handle-dialogflow-intent.md) function has returned true. |
