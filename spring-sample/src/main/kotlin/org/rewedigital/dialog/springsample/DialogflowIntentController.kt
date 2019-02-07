package org.rewedigital.dialog.springsample

import org.rewedigital.dialog.model.dialogflow.WebhookRequest
import org.rewedigital.dialog.model.dialogflow.WebhookResponse
import org.rewedigital.dialog.resolver.RequestResolver
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.*


@Controller
class DialogflowIntentController(private val requestResolver: RequestResolver) {

    @RequestMapping(path = ["/dialogflowIntent"], method = [RequestMethod.POST])
    fun dialogflowRequest(@RequestBody webhookRequest: WebhookRequest): ResponseEntity<WebhookResponse> {
        return ResponseEntity.of(Optional.ofNullable(requestResolver.resolveRequest(webhookRequest)))
    }
}