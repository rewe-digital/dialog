package org.rewedigital.dialog.utils

import org.rewedigital.dialog.model.google.RichResponse
import org.rewedigital.konversation.Konversation
import org.rewedigital.konversation.Output

fun RichResponse.withSimpleResponse(konversation: Konversation): RichResponse = apply {
    withSimpleResponse(konversation.createOutput())
}

fun RichResponse.withSimpleResponse(output: Output): RichResponse = apply {
    withSimpleResponse(ssml = output.ssml, displayText = output.displayText)
}