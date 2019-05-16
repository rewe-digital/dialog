package org.rewedigital.dialog.ssml

import org.rewedigital.dialog.utils.pickRandom
import org.rewedigital.dialog.utils.randomPick

/**
 * Helper class for construction of SSML [https://www.w3.org/TR/speech-synthesis11/] based responses.
 * This Helper only contain the supported SSML tags for Amazon Alexa and the Google Assistant.
 */
class SsmlBuilder(text: String = "") {
    private val stringBuilder = StringBuilder(text)

    private fun String.toSsmlString() = "<speak>$this</speak>"
    private fun String.escapeXml() = replace("&(?!\\w+;)".toRegex(), "&amp;").replace("'", "&apos;")
    private fun String.removeXmlTags() = replace("<[^>]+>".toRegex(), "")
    private fun String.removeVoiceOnlyOutput() = replace("(?s)<VO>(.+?(?=</VO>))</VO>".toRegex(), "")
    private fun String.removeVoiceOnlyMarker() = replace("</?VO>".toRegex(), "")

    /**
     * This will add the <break> [https://www.w3.org/TR/speech-synthesis11/#S3.2.3] tag to the SSML string.
     * You can either choose to set a [Strength], a time in milliseconds or the default for the break.
     */
    fun appendBreak(strength: Strength? = null, timeInMs: Int? = null) = apply {
        stringBuilder.append(ssmlBreak(strength, timeInMs))
    }

    /**
     * This will add the <prosody rate="slow"> tag [https://www.w3.org/TR/speech-synthesis11/#S3.2.3] to the
     * given string.
     */
    fun appendSlowText(text: String) = apply {
        stringBuilder.append(speedSlow(text))
    }

    /**
     * This will add the <audio> [https://www.w3.org/TR/speech-synthesis11/#S3.3.1] tag with the given URL.
     */
    fun appendAudio(url: String) = apply {
        stringBuilder.append("<audio src=\"$url\"/>")
    }

    /**
     * This will add the <say-as> [https://www.w3.org/TR/speech-synthesis11/#S3.1.9] tag with the attribute
     * [InterpretAs] to a given string.
     */
    fun appendSayAs(interpretAs: InterpretAs, text: String) = apply {
        stringBuilder.append(sayAs(interpretAs, text))
    }

    /**
     * This will add the <emphasis> [https://www.w3.org/TR/speech-synthesis11/#S3.2.2] tag with the attribute
     * [Emphasis] to a given string.
     */
    fun appendEmphasis(emphasis: Emphasis, text: String) = apply {
        stringBuilder.append("<emphasis level=\"${emphasis.name.toLowerCase()}\">$text</emphasis>")
    }

    /**
     * This will add the <amazon:effect> [https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#amazon-effect]
     * tag with the [AmazonEffect] to a given string.
     */
    fun appendAmazonEffect(text: String, amazonEffect: AmazonEffect = AmazonEffect.WHISPERED) = apply {
        stringBuilder.append("<amazon:effect name=\"$amazonEffect\">$text</amazon:effect>")
    }

    /**
     * This will add a <say-as> tag with the given speechcon for Alexa. [https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#supported-speechcons]
     */
    fun appendAlexaSpeechcon(speechcon: String) = apply {
        stringBuilder.append(sayAsSpeechcon(speechcon))
    }

    /**
     * This will add a <say-as> tag with a randomly chosen speechcon for Alexa. [https://developer.amazon.com/docs/custom-skills/speech-synthesis-markup-language-ssml-reference.html#supported-speechcons]
     */
    fun appendAlexaSpeechconRandom(vararg speechcons: String) = apply {
        stringBuilder.append(speechcons.toList().pickRandom().orEmpty())
    }

    /**
     * This will add more text to the [SsmlBuilder]
     */
    fun appendText(text: String) = apply {
        stringBuilder.append(text)
    }

    /**
     * This will add an other [SsmlBuilder] to this one.
     */
    fun appendText(text: SsmlBuilder) = apply {
        stringBuilder.append(text.stringBuilder)
    }

    /**
     * This will add more text to the [SsmlBuilder]
     */
    operator fun plus(text: String) = appendText(text)

    /**
     * This will add an other [SsmlBuilder] to this one.
     */
    operator fun plus(text: SsmlBuilder) = appendText(text)

    /**
     * This will randomly append one of the given strings to this [SsmlBuilder]
     */
    fun appendRandomOf(vararg text: String) = apply {
        stringBuilder.append(text.randomPick())
    }

    /**
     * This will add a <sub> [https://www.w3.org/TR/speech-synthesis11/#S3.1.11] tag with the given
     * text and alias.
     */
    fun appendSubAlias(text: String, alias: String) = apply {
        stringBuilder.append(subAlias(text, alias))
    }

    fun appendSpeech(text: String) = this.apply {
        appendText("<VO>").appendText(text).appendText("</VO>")
    }

    fun appendRandomSpeechOf(vararg text: String) = this.apply {
        appendText("<VO>").appendText(text.randomPick()).appendText("</VO>")
    }

    /**
     * Returns the containing string without any SSML tags.
     */
    fun asDisplayText() = stringBuilder.toString().removeVoiceOnlyOutput().removeXmlTags()

    /**
     * Returns the containing string.
     */
    override fun toString(): String = stringBuilder.toString()

    /**
     * Returns the containing string with a start and end <speak> tag.
     */
    fun asSsmlString() = stringBuilder.toString().toSsmlString().removeVoiceOnlyMarker().escapeXml()

    companion object {
        fun subAlias(text: String, alias: String) = "<sub alias=\"$alias\">$text</sub>"
        fun speedSlow(text: String) = "<prosody rate=\"slow\">$text</prosody>"
        fun sayAs(interpretAs: InterpretAs, text: String) =
            "<say-as interpret-as=\"${interpretAs.name.toLowerCase()}\">$text</say-as>"

        fun sayAsSpeechcon(speechcon: String?) =
            if (speechcon != null) sayAs(InterpretAs.INTERJECTION, speechcon) else ""

        fun ssmlBreak(strength: Strength? = null, timeInMs: Int? = null) = "<break${
        when {
            strength != null -> " strength=\"${strength.value}\""
            timeInMs != null -> " time=\"${timeInMs}ms\""
            else -> ""
        }
        }/>"
    }
}