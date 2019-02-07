package org.rewedigital.dialog.model.google


data class AppRequest(
    var availableSurfaces: List<Surface>? = null,
    var conversation: Conversation? = null,
    var device: Device? = null,
    var inputs: MutableList<Input>? = null,
    var isInSandbox: Boolean? = null,
    var surface: Surface? = null,
    var user: User? = null
)