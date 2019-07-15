package org.rewedigital.dialog.utils

import java.util.*

private val random = Random()

internal fun <T> List<T>.pickRandom(): T? =
    if (isEmpty()) {
        null
    } else {
        get(random.nextInt(size))
    }

internal fun Array<out String>.randomPick(): String =
    if (isEmpty()) {
        ""
    } else {
        get(random.nextInt(size))
    }