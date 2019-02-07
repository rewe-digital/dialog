[core](../../index.md) / [org.rewedigital.dialog.interceptors](../index.md) / [ResponseInterceptor](./index.md)

# ResponseInterceptor

`interface ResponseInterceptor`

Indicates an interceptor for outgoing requests. This class will be called from
the [org.rewedigital.dialog.resolver.RequestResolver](../../org.rewedigital.dialog.resolver/-request-resolver/index.md).

Maybe used for tracking or logging.

### Functions

| Name | Summary |
|---|---|
| [onDialogflowResponse](on-dialogflow-response.md) | `open fun onDialogflowResponse(webhookRequest: `[`WebhookRequest`](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md)`, webhookResponse: `[`WebhookResponse`](../../org.rewedigital.dialog.model.dialogflow/-webhook-response/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
