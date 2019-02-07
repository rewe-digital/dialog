[core](../../index.md) / [org.rewedigital.dialog.handler](../index.md) / [DialogflowHandler](./index.md)

# DialogflowHandler

`class DialogflowHandler`

Wrapper of [WebhookRequest](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md) which provides utility functions  for easier context access and other parameters.
And also provides instance of [DialogflowResponseBuilder](../-dialogflow-response-builder/index.md).

### Types

| Name | Summary |
|---|---|
| [ContextWrapper](-context-wrapper/index.md) | `class ContextWrapper` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DialogflowHandler(webhookRequest: `[`WebhookRequest`](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md)`)`<br>Wrapper of [WebhookRequest](../../org.rewedigital.dialog.model.dialogflow/-webhook-request/index.md) which provides utility functions  for easier context access and other parameters. And also provides instance of [DialogflowResponseBuilder](../-dialogflow-response-builder/index.md). |

### Properties

| Name | Summary |
|---|---|
| [accessToken](access-token.md) | `val accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>An OAuth2 token that identifies the user in your system. Only available if Account Linking configuration is defined in the action package and the user links their account. |
| [action](action.md) | `val action: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>The action name defined in Dialogflow. |
| [arguments](arguments.md) | `val arguments: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>The collection of extracted entities. |
| [context](context.md) | `val context: `[`ContextWrapper`](-context-wrapper/index.md)<br>Holds context related information. |
| [intentName](intent-name.md) | `val intentName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>The intent name defined in Dialogflow. |
| [isNewSession](is-new-session.md) | `val isNewSession: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates if the current session has type of [Conversation.Type.NEW](../../org.rewedigital.dialog.model.google/-conversation/-type/-n-e-w.md) |
| [languageCode](language-code.md) | `val languageCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>The language that was triggered during intent detection. |
| [originalRequest](original-request.md) | `val originalRequest: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Returns the original request string from Dialogflow. |
| [responseBuilder](response-builder.md) | `val responseBuilder: `[`DialogflowResponseBuilder`](../-dialogflow-response-builder/index.md)<br>Returns an [DialogflowResponseBuilder](../-dialogflow-response-builder/index.md) which can be used to construct a complete webhook response containing speech and visual components. |
| [sessionId](session-id.md) | `val sessionId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>The unique identifier of detectIntent request session. Can be used to identify end-user inside webhook implementation. Format: projects//agent/sessions/, or projects//agent/environments//users//sessions/. |
| [userId](user-id.md) | `val userId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>An unique identifier of the users google account. |

### Functions

| Name | Summary |
|---|---|
| [getArgument](get-argument.md) | `fun getArgument(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?`<br>Returns the value for the key from [arguments](arguments.md). |
| [getContext](get-context.md) | `fun getContext(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`OutputContext`](../../org.rewedigital.dialog.model.dialogflow/-output-context/index.md)`?`<br>Returns the context for the given name. |
| [getContextList](get-context-list.md) | `fun getContextList(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OutputContext`](../../org.rewedigital.dialog.model.dialogflow/-output-context/index.md)`>`<br>Returns all contexts. |
| [getContextParam](get-context-param.md) | `fun getContextParam(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?`<br>Returns the context parameter value for the given name and key |
| [hasSurfaceCapability](has-surface-capability.md) | `fun hasSurfaceCapability(capability: `[`SurfaceCapabilities`](../../org.rewedigital.dialog.model.google/-surface-capabilities/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the request has the given [SurfaceCapabilities](../../org.rewedigital.dialog.model.google/-surface-capabilities/index.md) |
| [permissionGranted](permission-granted.md) | `fun permissionGranted(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if on the last request a permission was successfully granted. |
| [selectedOption](selected-option.md) | `fun selectedOption(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Returns the selected option after a [org.rewedigital.dialog.model.google.SystemIntents.OPTION](../../org.rewedigital.dialog.model.google/-system-intents/-o-p-t-i-o-n.md) |
| [setContext](set-context.md) | `fun setContext(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lifespan: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 4, params: `[`DialogflowParams`](../../org.rewedigital.dialog.model.dialogflow/-dialogflow-params.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set a context and overwrites the old one, with the same name, if present. |
| [setContextParam](set-context-param.md) | `fun setContextParam(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set a context parameter. |
| [signInStatus](sign-in-status.md) | `fun signInStatus(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Returns the current sign in status. Status can be one of [org.rewedigital.dialog.model.google.Status.SignIn](../../org.rewedigital.dialog.model.google/-status/-sign-in/index.md). |
