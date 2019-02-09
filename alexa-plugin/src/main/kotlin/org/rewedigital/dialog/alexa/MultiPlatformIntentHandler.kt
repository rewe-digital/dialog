package org.rewedigital.dialog.alexa

import com.amazon.ask.dispatcher.request.handler.RequestHandler
import org.rewedigital.dialog.handler.DialogflowIntentHandler


interface MultiPlatformIntentHandler : DialogflowIntentHandler, RequestHandler 