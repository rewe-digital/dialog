package org.rewedigital.dialog.utils

import org.rewedigital.dialog.handler.DialogflowHandler
import org.rewedigital.konversation.Environment
import org.rewedigital.konversation.Konversation

fun DialogflowHandler.loadKonversation(name: String) =
    Konversation(name, Environment("google", languageCode.orEmpty()))

fun DialogflowHandler.loadKonversation(konversation: KonversationEnum) =
    Konversation(konversation.intentName, Environment("google", languageCode.orEmpty()))