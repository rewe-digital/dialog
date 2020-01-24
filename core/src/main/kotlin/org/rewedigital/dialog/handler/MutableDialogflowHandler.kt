package org.rewedigital.dialog.handler

import org.rewedigital.dialog.model.dialogflow.WebhookRequest

/**
 * Mutable version of the [DialogflowHandler] for modifying requests.
 */
class MutableDialogflowHandler(private val handler : DialogflowHandler, webhookRequest: WebhookRequest) : DialogflowHandler(webhookRequest) {
    override var context = handler.context
    override var userData = handler.userData
    override var action = handler.action
    override var originalRequest = handler.originalRequest
    override var isNewSession = handler.isNewSession
    override var intentName = handler.intentName
    override var userId = handler.userId
    override var sessionId = handler.sessionId
    override var accessToken = handler.accessToken
    override var isUserVerified = handler.isUserVerified
    override var responseBuilder = handler.responseBuilder
    override var languageCode = handler.languageCode
    override var fulfillmentText = handler.fulfillmentText
    override var fulfillmentMessages = handler.fulfillmentMessages
    override var intentDetectionConfidence = handler.intentDetectionConfidence
    override var speechRecognitionConfidence = handler.speechRecognitionConfidence
    override var inputType = handler.inputType
    override var arguments = handler.arguments
}