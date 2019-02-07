package org.rewedigital.dialog.model.google

data class GoogleBasicCard(
    var title: String? = null,
    var subtitle: String? = null,
    var formattedText: String? = null,
    var image: GoogleImage? = null,
    var buttons: MutableList<GoogleButton> = mutableListOf(),
    var imageDisplayOptions: ImageDisplayOptions? = ImageDisplayOptions.CROPPED
)