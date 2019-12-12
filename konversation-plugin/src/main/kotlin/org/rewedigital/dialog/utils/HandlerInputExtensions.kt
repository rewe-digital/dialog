package org.rewedigital.dialog.utils

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import org.rewedigital.konversation.Environment
import org.rewedigital.konversation.Konversation

fun HandlerInput.loadKonversation(name: String) =
    Konversation(name, Environment("amazon", requestEnvelope.request.locale))

fun HandlerInput.loadKonversation(konversation: KonversationEnum) =
    Konversation(konversation.intentName, Environment("amazon", requestEnvelope.request.locale))