package org.rewedigital.dialog.model.google

data class GoogleButton(
    var title: String? = null,
    var openUrlAction: OpenUrlAction? = null
) {
    constructor(title: String, url: String) : this(title, OpenUrlAction(url))
}