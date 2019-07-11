package org.rewedigital.dialog.model.google

data class GooglePayload(
    var isSsml: Boolean = false,
    var expectUserResponse: Boolean = false,
    var text: String? = null,
    var permissionsRequest: PermissionsRequest? = null,
    var systemIntent: SystemIntent? = null,
    var richResponse: RichResponse? = null,
    override var userStorage: String? = null,
    var noInputPrompts: MutableList<GoogleSimpleResponse> = mutableListOf()
) : UserStorageHolder