package org.rewedigital.dialog.model.dialogflow

data class OptionInfo(
    val key: String? = null,
    val synonyms: List<String> = emptyList()
) {
    constructor(key: String, vararg synonyms: String): this(key, synonyms.toList())
}