package org.rewedigital.dialog.model.google

data class MediaResponse(
    var mediaType: MediaType = MediaType.MEDIA_TYPE_UNSPECIFIED,
    var mediaObjects: MutableList<MediaObject> = mutableListOf()
)