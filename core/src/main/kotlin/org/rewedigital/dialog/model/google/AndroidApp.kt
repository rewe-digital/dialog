package org.rewedigital.dialog.model.google

data class AndroidApp(
    var packageName: String? = null,
    var versions: MutableList<AndroidAppVersionFilter> = mutableListOf()
)
