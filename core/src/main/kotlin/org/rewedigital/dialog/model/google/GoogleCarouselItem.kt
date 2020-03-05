package org.rewedigital.dialog.model.google

import org.rewedigital.dialog.model.dialogflow.Image
import org.rewedigital.dialog.model.dialogflow.Item
import org.rewedigital.dialog.model.dialogflow.OptionInfo
import org.rewedigital.dialog.model.dialogflow.SelectItemInfo

data class GoogleCarouselItem(
    var description: String? = null,
    var image: GoogleImage? = null,
    val optionInfo: OptionInfo? = null,
    var title: String
) {
    fun toDialogflowModel() = Item(
        info = optionInfo?.let { SelectItemInfo(optionInfo.key, optionInfo.synonyms.toMutableList()) },
        title = title,
        image = image?.let { img ->
            Image(
                imageUri = img.url,
                accessibilityText = img.accessibilityText,
                height = img.height,
                width = img.width
            )
        },
        description = description
    )
}