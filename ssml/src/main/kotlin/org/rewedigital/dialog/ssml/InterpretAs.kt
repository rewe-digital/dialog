package org.rewedigital.dialog.ssml

/**
 * Possible types of interpret-as for the <say-as> tag. [https://www.w3.org/TR/speech-synthesis11/#S3.1.9]
 */
enum class InterpretAs {
    CARDINAL,
    ORDINAL,
    CHARACTERS,
    FRACTION,
    EXPLETIVE,
    UNIT,
    TELEPHONE,
    DATE,
    INTERJECTION,
}