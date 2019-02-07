package org.rewedigital.dialog.model.google


data class GoogleImage(
    val url: String,
    val accessibilityText: String,
    val height: Int? = null,
    val width: Int? = null
)