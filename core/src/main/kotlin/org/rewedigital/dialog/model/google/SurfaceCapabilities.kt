package org.rewedigital.dialog.model.google


enum class SurfaceCapabilities(val capabilityName: String) {
    AUDIO_OUT("actions.capability.AUDIO_OUTPUT"),
    SCREEN_OUTPUT("actions.capability.SCREEN_OUTPUT"),
    WEB_BROWSER("actions.capability.WEB_BROWSER"),
    MEDIA_RESPONSE_AUDIO("actions.capability.MEDIA_RESPONSE_AUDIO")
}