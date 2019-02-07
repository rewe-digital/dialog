[core](../../index.md) / [org.rewedigital.dialog.handler](../index.md) / [DialogflowIntentHandler](index.md) / [handleDialogflowIntent](./handle-dialogflow-intent.md)

# handleDialogflowIntent

`abstract fun handleDialogflowIntent(handler: `[`DialogflowHandler`](../-dialogflow-handler/index.md)`): `[`DialogflowResponseBuilder`](../-dialogflow-response-builder/index.md)`?`

The [org.rewedigital.dialog.resolver.RequestResolver](../../org.rewedigital.dialog.resolver/-request-resolver/index.md) will call this function if the [canHandleDialogflowIntent](can-handle-dialogflow-intent.md)
function has returned true.

The logic for handling the Intent goes here. To create a response use the [DialogflowHandler.responseBuilder](../-dialogflow-handler/response-builder.md).

