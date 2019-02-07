package org.rewedigital.dialog.model.google.order

data class RejectionInfo(
    var type: ReasonType = ReasonType.UNKNOWN,
    var reason: String? = null
)