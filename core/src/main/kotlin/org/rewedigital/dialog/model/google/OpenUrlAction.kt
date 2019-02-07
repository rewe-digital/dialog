package org.rewedigital.dialog.model.google

data class OpenUrlAction(
    var url: String? = null,
    var androidApp: AndroidApp? = null,
    var urlTypeHint: UrlTypeHint? = null
)
