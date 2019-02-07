package org.rewedigital.dialog.model.google


data class SystemIntent(
    var spec: Spec? = null,
    var intent: String? = null,
    var data: Data? = null
) {
    constructor(
        spec: Spec? = null,
        intent: SystemIntents? = null,
        data: Data? = null
    ) : this(spec, intent?.intentName, data)

    companion object {
        fun createCarouselSelect(vararg items: GoogleCarouselItem) =
            SystemIntent(
                intent = SystemIntents.OPTION,
                data = Data(
                    `@type` = InputValueDataTypes.OPTION.type,
                    carouselSelect = GoogleCarouselSelect(items.toList())
                )
            )
    }
}