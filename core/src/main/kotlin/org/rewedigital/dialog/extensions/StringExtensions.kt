package org.rewedigital.dialog.extensions


private val ssmlRegex = "^(?i)<speak\\b[^>]*>(.*?)</speak>$".toRegex()

internal fun String.isSsml() = ssmlRegex.containsMatchIn(this)