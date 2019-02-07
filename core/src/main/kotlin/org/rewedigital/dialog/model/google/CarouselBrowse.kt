package org.rewedigital.dialog.model.google

data class CarouselBrowse(
    var items: MutableList<GoogleCarouselItem> = mutableListOf(),
    var imageDisplayOptions: ImageDisplayOptions = ImageDisplayOptions.CROPPED
)