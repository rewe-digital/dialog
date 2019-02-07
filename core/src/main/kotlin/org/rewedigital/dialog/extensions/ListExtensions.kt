package org.rewedigital.dialog.extensions


internal fun <T> MutableList<T>?.orEmpty() = this ?: mutableListOf()