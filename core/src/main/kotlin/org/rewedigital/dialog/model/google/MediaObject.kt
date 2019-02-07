package org.rewedigital.dialog.model.google

import org.rewedigital.dialog.model.dialogflow.Image

interface MediaObject {
    var name: String?
    var description: String?
    var contentUrl: String?
}

data class LargeImageMediaObject(
    override var name: String? = null,
    override var description: String? = null,
    override var contentUrl: String? = null,
    var largeImage: Image? = null
) : MediaObject

data class IconMediaObject(
    override var name: String? = null,
    override var description: String? = null,
    override var contentUrl: String? = null,
    var icon: Image? = null
) : MediaObject