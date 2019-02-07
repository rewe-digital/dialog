[core](../../index.md) / [org.rewedigital.dialog.model.google](../index.md) / [RichResponse](./index.md)

# RichResponse

`data class RichResponse`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RichResponse(items: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ResponseHolder`](../-response-holder.md)`> = mutableListOf(), suggestions: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Suggestion`](../../org.rewedigital.dialog.model.dialogflow/-suggestion/index.md)`> = mutableListOf(), linkOutSuggestion: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`LinkOutSuggestion`](../../org.rewedigital.dialog.model.dialogflow/-link-out-suggestion/index.md)`> = mutableListOf())` |

### Properties

| Name | Summary |
|---|---|
| [items](items.md) | `val items: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ResponseHolder`](../-response-holder.md)`>` |
| [linkOutSuggestion](link-out-suggestion.md) | `val linkOutSuggestion: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`LinkOutSuggestion`](../../org.rewedigital.dialog.model.dialogflow/-link-out-suggestion/index.md)`>` |
| [suggestions](suggestions.md) | `val suggestions: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Suggestion`](../../org.rewedigital.dialog.model.dialogflow/-suggestion/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [withBasicCard](with-basic-card.md) | `fun withBasicCard(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, subtitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, formattedText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, image: `[`GoogleImage`](../-google-image/index.md)`? = null, buttons: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`GoogleButton`](../-google-button/index.md)`> = mutableListOf(), imageDisplayOptions: `[`ImageDisplayOptions`](../-image-display-options/index.md)`? = ImageDisplayOptions.CROPPED): `[`RichResponse`](./index.md) |
| [withCarousel](with-carousel.md) | `fun withCarousel(items: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`GoogleCarouselItem`](../-google-carousel-item/index.md)`> = mutableListOf(), imageDisplayOptions: `[`ImageDisplayOptions`](../-image-display-options/index.md)` = ImageDisplayOptions.CROPPED): `[`RichResponse`](./index.md) |
| [withLinkOutSuggestion](with-link-out-suggestion.md) | `fun withLinkOutSuggestion(destinationName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, uri: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`RichResponse`](./index.md) |
| [withLinkOutSuggestions](with-link-out-suggestions.md) | `fun withLinkOutSuggestions(suggestions: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`RichResponse`](./index.md)<br>`fun withLinkOutSuggestions(vararg suggestions: `[`LinkOutSuggestion`](../../org.rewedigital.dialog.model.dialogflow/-link-out-suggestion/index.md)`): `[`RichResponse`](./index.md) |
| [withMediaResponse](with-media-response.md) | `fun withMediaResponse(mediaType: `[`MediaType`](../-media-type/index.md)` = MediaType.MEDIA_TYPE_UNSPECIFIED, mediaObjects: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`MediaObject`](../-media-object/index.md)`> = mutableListOf()): `[`RichResponse`](./index.md) |
| [withSimpleResponse](with-simple-response.md) | `fun withSimpleResponse(textToSpeech: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, ssml: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, displayText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`RichResponse`](./index.md) |
| [withSuggestions](with-suggestions.md) | `fun withSuggestions(vararg suggestions: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`RichResponse`](./index.md) |
| [withTableCard](with-table-card.md) | `fun withTableCard(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, subtitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, image: `[`Image`](../../org.rewedigital.dialog.model.dialogflow/-image/index.md)`? = null, columnProperties: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ColumnProperties`](../../org.rewedigital.dialog.model.google.table/-column-properties/index.md)`> = mutableListOf(), rows: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Row`](../../org.rewedigital.dialog.model.google.table/-row/index.md)`> = mutableListOf(), buttons: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Button`](../../org.rewedigital.dialog.model.dialogflow/-button/index.md)`> = mutableListOf()): `[`RichResponse`](./index.md) |
