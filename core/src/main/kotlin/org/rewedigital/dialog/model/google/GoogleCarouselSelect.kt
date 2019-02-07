package org.rewedigital.dialog.model.google

import org.rewedigital.dialog.model.dialogflow.CarouselSelect

data class GoogleCarouselSelect(
    val items: List<GoogleCarouselItem>
) {
    fun toDialogflowModel() = CarouselSelect(items.map { it.toDialogflowModel() }.toMutableList())
}