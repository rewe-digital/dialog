package org.rewedigital.dialog.utils

interface KonversationEnum {
    val name: String
    val alias: String?
}

internal val KonversationEnum.intentName: String
    get() = alias ?: name