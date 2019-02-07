package org.rewedigital.dialog.model.google


data class Conversation(
    val conversationId: String?,
    val conversationToken: String?,
    val type: Type?
) {
    enum class Type {
        TYPE_UNSPECIFIED,
        NEW,
        ACTIVE
    }
}