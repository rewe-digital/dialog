package org.rewedigital.dialog.utils

import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.google.GoogleSimpleResponse
import org.rewedigital.dialog.model.google.RichResponse
import org.rewedigital.dialog.ssml.SsmlBuilder

fun DialogflowResponseBuilder.withGoogleSimpleResponse(ssml: SsmlBuilder) : DialogflowResponseBuilder = apply {
    withGoogleSimpleResponse(GoogleSimpleResponse(ssml = ssml.asSsmlString(), displayText = ssml.asDisplayText()))
}

fun RichResponse.withSimpleResponse(ssml: SsmlBuilder) : RichResponse = apply {
    withSimpleResponse(ssml = ssml.asSsmlString(), textToSpeech = ssml.asDisplayText())
}