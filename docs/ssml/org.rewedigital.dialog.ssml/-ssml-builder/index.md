[ssml](../../index.md) / [org.rewedigital.dialog.ssml](../index.md) / [SsmlBuilder](./index.md)

# SsmlBuilder

`class SsmlBuilder`

Helper class for construction of SSML [https://www.w3.org/TR/speech-synthesis11/](https://www.w3.org/TR/speech-synthesis11/) based responses.
This Helper only contain the supported SSML tags for Amazon Alexa and the Google Assistant.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SsmlBuilder(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "")`<br>Helper class for construction of SSML [https://www.w3.org/TR/speech-synthesis11/](https://www.w3.org/TR/speech-synthesis11/) based responses. This Helper only contain the supported SSML tags for Amazon Alexa and the Google Assistant. |

### Functions

| Name | Summary |
|---|---|
| [appendAlexaSpeechcon](append-alexa-speechcon.md) | `fun appendAlexaSpeechcon(speechcon: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add a &lt;say-as&gt; tag with the given speechcon for Alexa. [https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#supported-speechcons](https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#supported-speechcons) |
| [appendAlexaSpeechconRandom](append-alexa-speechcon-random.md) | `fun appendAlexaSpeechconRandom(vararg speechcons: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add a &lt;say-as&gt; tag with a randomly chosen speechcon for Alexa. [https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#supported-speechcons](https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#supported-speechcons) |
| [appendAmazonEffect](append-amazon-effect.md) | `fun appendAmazonEffect(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, amazonEffect: `[`AmazonEffect`](../-amazon-effect/index.md)` = AmazonEffect.WHISPERED): `[`SsmlBuilder`](./index.md)<br>This will add the &lt;&gt; [https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#amazon-effect](https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#amazon-effect) tag with the [AmazonEffect](../-amazon-effect/index.md) to a given string. |
| [appendAudio](append-audio.md) | `fun appendAudio(url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add the  [https://www.w3.org/TR/speech-synthesis11/#S3.3.1](https://www.w3.org/TR/speech-synthesis11/#S3.3.1) tag with the given URL. |
| [appendBreak](append-break.md) | `fun appendBreak(strength: `[`Strength`](../-strength/index.md)`? = null, timeInMs: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): `[`SsmlBuilder`](./index.md)<br>This will add the  [https://www.w3.org/TR/speech-synthesis11/#S3.2.3](https://www.w3.org/TR/speech-synthesis11/#S3.2.3) tag to the SSML string. You can either choose to set a [Strength](../-strength/index.md), a time in milliseconds or the default for the break. |
| [appendEmphasis](append-emphasis.md) | `fun appendEmphasis(emphasis: `[`Emphasis`](../-emphasis/index.md)`, text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add the  [https://www.w3.org/TR/speech-synthesis11/#S3.2.2](https://www.w3.org/TR/speech-synthesis11/#S3.2.2) tag with the attribute [Emphasis](../-emphasis/index.md) to a given string. |
| [appendRandomOf](append-random-of.md) | `fun appendRandomOf(vararg text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will randomly append one of the given strings to this [SsmlBuilder](./index.md) |
| [appendRandomSpeechOf](append-random-speech-of.md) | `fun appendRandomSpeechOf(vararg text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md) |
| [appendSayAs](append-say-as.md) | `fun appendSayAs(interpretAs: `[`InterpretAs`](../-interpret-as/index.md)`, text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add the &lt;say-as&gt; [https://www.w3.org/TR/speech-synthesis11/#S3.1.9](https://www.w3.org/TR/speech-synthesis11/#S3.1.9) tag with the attribute [InterpretAs](../-interpret-as/index.md) to a given string. |
| [appendSlowText](append-slow-text.md) | `fun appendSlowText(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add the  tag [https://www.w3.org/TR/speech-synthesis11/#S3.2.3](https://www.w3.org/TR/speech-synthesis11/#S3.2.3) to the given string. |
| [appendSpeech](append-speech.md) | `fun appendSpeech(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md) |
| [appendSubAlias](append-sub-alias.md) | `fun appendSubAlias(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, alias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add a  [https://www.w3.org/TR/speech-synthesis11/#S3.1.11](https://www.w3.org/TR/speech-synthesis11/#S3.1.11) tag with the given text and alias. |
| [appendText](append-text.md) | `fun appendText(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add more text to the [SsmlBuilder](./index.md)`fun appendText(text: `[`SsmlBuilder`](./index.md)`): `[`SsmlBuilder`](./index.md)<br>This will add an other [SsmlBuilder](./index.md) to this one. |
| [asDisplayText](as-display-text.md) | `fun asDisplayText(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns the containing string without any SSML tags. |
| [asSsmlString](as-ssml-string.md) | `fun asSsmlString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns the containing string with a start and end  tag. |
| [plus](plus.md) | `operator fun plus(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`SsmlBuilder`](./index.md)<br>This will add more text to the [SsmlBuilder](./index.md)`operator fun plus(text: `[`SsmlBuilder`](./index.md)`): `[`SsmlBuilder`](./index.md)<br>This will add an other [SsmlBuilder](./index.md) to this one. |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns the containing string. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [sayAs](say-as.md) | `fun sayAs(interpretAs: `[`InterpretAs`](../-interpret-as/index.md)`, text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [sayAsSpeechcon](say-as-speechcon.md) | `fun sayAsSpeechcon(speechcon: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [speedSlow](speed-slow.md) | `fun speedSlow(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ssmlBreak](ssml-break.md) | `fun ssmlBreak(strength: `[`Strength`](../-strength/index.md)`? = null, timeInMs: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [subAlias](sub-alias.md) | `fun subAlias(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, alias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
