[core](../../../index.md) / [org.rewedigital.dialog.handler](../../index.md) / [DialogflowHandler](../index.md) / [ContextWrapper](./index.md)

# ContextWrapper

`class ContextWrapper`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ContextWrapper(context: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`OutputContext`](../../../org.rewedigital.dialog.model.dialogflow/-output-context/index.md)`>, session: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [asList](as-list.md) | `fun asList(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OutputContext`](../../../org.rewedigital.dialog.model.dialogflow/-output-context/index.md)`>` |
| [get](get.md) | `operator fun get(contextName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`OutputContext`](../../../org.rewedigital.dialog.model.dialogflow/-output-context/index.md)`?`<br>`operator fun get(contextName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, parameter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?` |
| [hasAnyContext](has-any-context.md) | `fun hasAnyContext(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [plusAssign](plus-assign.md) | `operator fun plusAssign(context: `[`OutputContext`](../../../org.rewedigital.dialog.model.dialogflow/-output-context/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [set](set.md) | `operator fun set(contextName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`OutputContext`](../../../org.rewedigital.dialog.model.dialogflow/-output-context/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`operator fun set(contextName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, parameter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
