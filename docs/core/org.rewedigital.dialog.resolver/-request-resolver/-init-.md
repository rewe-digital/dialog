[core](../../index.md) / [org.rewedigital.dialog.resolver](../index.md) / [RequestResolver](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`RequestResolver(intentHandlers: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`DialogflowIntentHandler`](../../org.rewedigital.dialog.handler/-dialogflow-intent-handler/index.md)`>, requestInterceptors: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RequestInterceptor`](../../org.rewedigital.dialog.interceptors/-request-interceptor/index.md)`>, responseInterceptors: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ResponseInterceptor`](../../org.rewedigital.dialog.interceptors/-response-interceptor/index.md)`>, fallbackAction: (`[`DialogflowHandler`](../../org.rewedigital.dialog.handler/-dialogflow-handler/index.md)`) -> `[`DialogflowResponseBuilder`](../../org.rewedigital.dialog.handler/-dialogflow-response-builder/index.md)`?)`

[RequestResolver](index.md) handles incoming [WebhookRequest](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md), the [DialogflowIntentHandler.canHandleDialogflowIntent](../../org.rewedigital.dialog.handler/-dialogflow-intent-handler/can-handle-dialogflow-intent.md)
from all given [DialogflowIntentHandler](../../org.rewedigital.dialog.handler/-dialogflow-intent-handler/index.md) will be called to figure out witch [DialogflowIntentHandler](../../org.rewedigital.dialog.handler/-dialogflow-intent-handler/index.md)
can handle the incoming [WebhookRequest](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md).

The first [DialogflowIntentHandler](../../org.rewedigital.dialog.handler/-dialogflow-intent-handler/index.md) that [DialogflowIntentHandler.canHandleDialogflowIntent](../../org.rewedigital.dialog.handler/-dialogflow-intent-handler/can-handle-dialogflow-intent.md) returns true
will be used to handle the [WebhookRequest](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md). Therefor the [DialogflowIntentHandler.handleDialogflowIntent](../../org.rewedigital.dialog.handler/-dialogflow-intent-handler/handle-dialogflow-intent.md)
function will be called.

If there is no matching [DialogflowIntentHandler](../../org.rewedigital.dialog.handler/-dialogflow-intent-handler/index.md) the [fallbackAction](#) will be triggered.

It's possible to provide [RequestInterceptor](../../org.rewedigital.dialog.interceptors/-request-interceptor/index.md) and [ResponseInterceptor](../../org.rewedigital.dialog.interceptors/-response-interceptor/index.md), they will be triggered for every
incoming [WebhookRequest](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md) and outgoing [WebhookResponse](../../org.rewedigital.dialog.model.dialogflow/-webhook-response/index.md).

