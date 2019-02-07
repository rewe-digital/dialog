package org.rewedigital.dialog.model.google


data class PermissionsRequest(
    var optContext: String? = null,
    var permissions: MutableList<String> = mutableListOf(),
    var expectUserResponse: Boolean = false,
    var intent: String? = null
)