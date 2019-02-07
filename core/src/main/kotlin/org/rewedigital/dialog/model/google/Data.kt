package org.rewedigital.dialog.model.google


data class Data(
    var `@type`: String? = null,
    var optContext: String? = null,
    var permissions: MutableList<String>? = null,
    var name: String? = null,
    var context: String? = null,
    var notificationTitle: String? = null,
    var capabilities: MutableList<String> = mutableListOf(),
    val carouselSelect: GoogleCarouselSelect? = null
) {
    constructor(
        inputValueDataType: InputValueDataTypes? = null,
        permissions: MutableList<Permissions>? = null,
        optContext: String? = null
    ) : this(
        `@type` = inputValueDataType?.type,
        permissions = permissions?.map { it.name }?.toMutableList(),
        optContext = optContext
    )
}