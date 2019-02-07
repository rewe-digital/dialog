package org.rewedigital.dialog.ssml

/**
 * Possible strengths for the <break> tag. [https://www.w3.org/TR/speech-synthesis11/#S3.2.3]
 */
enum class Strength(val value: String) {
    MEDIUM("medium"),
    STRONG("strong"),
    XSTRONG("x-strong")
}