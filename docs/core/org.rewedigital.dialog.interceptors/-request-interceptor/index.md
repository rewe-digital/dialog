[core](../../index.md) / [org.rewedigital.dialog.interceptors](../index.md) / [RequestInterceptor](./index.md)

# RequestInterceptor

`interface RequestInterceptor`

Indicates an interceptor for incoming requests. This class will be called from
the [org.rewedigital.dialog.resolver.RequestResolver](../../org.rewedigital.dialog.resolver/-request-resolver/index.md).

Maybe used for tracking or logging.

### Functions

| Name | Summary |
|---|---|
| [onDialogflowRequest](on-dialogflow-request.md) | `open fun onDialogflowRequest(webhookRequest: `[`WebhookRequest`](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
