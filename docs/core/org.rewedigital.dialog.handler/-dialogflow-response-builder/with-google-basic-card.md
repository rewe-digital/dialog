[core](../../index.md) / [org.rewedigital.dialog.handler](../index.md) / [DialogflowResponseBuilder](index.md) / [withGoogleBasicCard](./with-google-basic-card.md)

# withGoogleBasicCard

`fun withGoogleBasicCard(basicCard: `[`GoogleBasicCard`](../../org.rewedigital.dialog.model.google/-google-basic-card/index.md)`): `[`DialogflowResponseBuilder`](index.md)
`fun withGoogleBasicCard(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, subtitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, formattedText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, image: `[`GoogleImage`](../../org.rewedigital.dialog.model.google/-google-image/index.md)`? = null, buttons: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`GoogleButton`](../../org.rewedigital.dialog.model.google/-google-button/index.md)`> = mutableListOf(), imageDisplayOptions: `[`ImageDisplayOptions`](../../org.rewedigital.dialog.model.google/-image-display-options/index.md)`? = ImageDisplayOptions.CROPPED): `[`DialogflowResponseBuilder`](index.md)

Adds a [GoogleBasicCard](../../org.rewedigital.dialog.model.google/-google-basic-card/index.md). [RichResponse](../../org.rewedigital.dialog.model.google/-rich-response/index.md) must start with a [GoogleSimpleResponse](../../org.rewedigital.dialog.model.google/-google-simple-response/index.md).
Only one [GoogleBasicCard](../../org.rewedigital.dialog.model.google/-google-basic-card/index.md) per [RichResponse](../../org.rewedigital.dialog.model.google/-rich-response/index.md) is allowed.

