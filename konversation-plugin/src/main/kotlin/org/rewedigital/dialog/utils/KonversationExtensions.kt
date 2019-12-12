package org.rewedigital.dialog.utils

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.response.ResponseBuilder
import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.dialog.handler.DialogflowResponseBuilder
import org.rewedigital.dialog.model.google.GoogleSimpleResponse
import org.rewedigital.dialog.model.google.RichResponse
import org.rewedigital.konversation.Environment
import org.rewedigital.konversation.Konversation
import org.rewedigital.konversation.Output

fun DialogflowResponseBuilder.withGoogleSimpleResponse(konversation: Konversation): DialogflowResponseBuilder = apply {
    withGoogleSimpleResponse(konversation.createOutput())
}

fun RichResponse.withSimpleResponse(konversation: Konversation): RichResponse = apply {
    withSimpleResponse(konversation.createOutput())
}

fun DialogflowResponseBuilder.withGoogleSimpleResponse(output: Output): DialogflowResponseBuilder = apply {
    withGoogleSimpleResponse(GoogleSimpleResponse(ssml = output.ssml, displayText = output.displayText))
}

fun RichResponse.withSimpleResponse(output: Output): RichResponse = apply {
    withSimpleResponse(ssml = output.ssml, displayText = output.displayText)
}

fun DialogflowHandler.loadKonversation(name: String) =
    Konversation(name, Environment("google", languageCode.orEmpty()))

fun DialogflowResponseBuilder.withGoogleSuggestions(output: Output): DialogflowResponseBuilder = apply {
    withGoogleSuggestions(*output.suggestions.toTypedArray())
}

fun DialogflowResponseBuilder.withGoogleSuggestions(konversation: Konversation): DialogflowResponseBuilder = apply {
    withGoogleSuggestions(konversation.createOutput())
}

fun DialogflowResponseBuilder.withGoogleReprompts(konversation: Konversation): DialogflowResponseBuilder = apply {
    withGoogleReprompts(konversation.createOutput())
}

fun DialogflowResponseBuilder.withGoogleReprompts(output: Output): DialogflowResponseBuilder = apply {
    withGoogleReprompts(*output.reprompts.entries.sortedBy { it.key }.map { it.value }.toTypedArray())
}

fun ResponseBuilder.withSpeech(speech: Output) = apply {
    withSpeech(speech.ssml)
}

fun ResponseBuilder.withSpeech(konversation: Konversation) = apply {
    withSpeech(konversation.createOutput().ssml)
}

fun ResponseBuilder.withPromptAsReprompt(speech: Output) = apply {
    withReprompt(speech.ssml)
}

fun ResponseBuilder.withPromptAsReprompt(konversation: Konversation) = apply {
    withReprompt(konversation.createOutput().ssml)
}

fun ResponseBuilder.withReprompt(konversation: Konversation) = apply {
    withReprompt(konversation.createOutput().reprompts[1])
}

fun ResponseBuilder.withReprompt(output: Output) = apply {
    withReprompt(output.reprompts[1])
}

fun HandlerInput.loadKonversation(name: String) =
    Konversation(name, Environment("amazon", requestEnvelope.request.locale))

interface KonversationEnum {
    val name: String
}

fun HandlerInput.loadKonversation(konversation: KonversationEnum) =
    Konversation(konversation.name, Environment("amazon", requestEnvelope.request.locale))

fun DialogflowHandler.loadKonversation(konversation: KonversationEnum) =
    Konversation(konversation.name, Environment("google", languageCode.orEmpty()))

fun DialogflowResponseBuilder.withGoogleSimpleResponse(konversation: KonversationEnum) : DialogflowResponseBuilder = apply {
    withGoogleSimpleResponse(Konversation(konversation.name, Environment("google", request.languageCode.orEmpty())).createOutput())
}

private val DialogflowResponseBuilder.request
    get() =  DialogflowResponseBuilder.getRequestOf(this)

fun ResponseBuilder.withSpeech(konversation: KonversationEnum) = apply {
    withSpeech(Konversation(konversation.name, Environment("alexa", ""/*FIXME*/)).createOutput())
}