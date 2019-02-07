package org.rewedigital.dialog.utils

import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.google.GoogleSimpleResponse
import org.rewedigital.dialog.model.google.RichResponse
import org.rewedigital.konversation.Environment
import org.rewedigital.konversation.Konversation
import org.rewedigital.konversation.Output

fun DialogflowResponseBuilder.withGoogleSimpleResponse(konversation: Konversation) : DialogflowResponseBuilder = apply {
    withGoogleSimpleResponse(konversation.createOutput())
}

fun RichResponse.withSimpleResponse(konversation: Konversation) : RichResponse = apply {
    withSimpleResponse(konversation.createOutput())
}

fun DialogflowResponseBuilder.withGoogleSimpleResponse(output: Output) : DialogflowResponseBuilder = apply {
    withGoogleSimpleResponse(GoogleSimpleResponse(ssml = output.ssml, displayText = output.displayText))
}

fun RichResponse.withSimpleResponse(output: Output) : RichResponse = apply {
    withSimpleResponse(ssml = output.ssml, displayText = output.displayText)
}

fun DialogflowHandler.loadKonversation(name: String) =
    Konversation(name, Environment("google", languageCode.orEmpty()))

fun DialogflowResponseBuilder.withGoogleSuggestions(output: Output) : DialogflowResponseBuilder = apply {
    withGoogleSuggestions(*output.suggestions.toTypedArray())
}

fun DialogflowResponseBuilder.withGoogleSuggestions(konversation: Konversation) : DialogflowResponseBuilder = apply {
    withGoogleSuggestions(konversation.createOutput())
}

fun DialogflowResponseBuilder.withGoogleReprompts(konversation: Konversation) : DialogflowResponseBuilder = apply {
    withGoogleReprompts(konversation.createOutput())
}

fun DialogflowResponseBuilder.withGoogleReprompts(output: Output) : DialogflowResponseBuilder = apply {
    withGoogleReprompts(*output.reprompts.entries.sortedBy { it.key }.map { it.value }.toTypedArray())
}