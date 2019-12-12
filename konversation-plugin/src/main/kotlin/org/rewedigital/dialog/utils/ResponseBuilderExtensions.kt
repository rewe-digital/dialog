package org.rewedigital.dialog.utils

import com.amazon.ask.response.ResponseBuilder
import org.rewedigital.konversation.Environment
import org.rewedigital.konversation.Konversation
import org.rewedigital.konversation.Output

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

fun ResponseBuilder.withSpeech(konversation: KonversationEnum) = apply {
    withSpeech(Konversation(konversation.intentName, Environment("alexa", ""/*FIXME*/)).createOutput())
}