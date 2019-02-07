package org.rewedigital.dialog.extensions

import org.rewedigital.dialog.model.dialogflow.WebhookRequest
import org.rewedigital.dialog.model.dialogflow.WebhookResponse
import org.rewedigital.dialog.model.google.Input
import org.rewedigital.dialog.model.google.Input.Argument.ArgumentNames.*
import org.rewedigital.dialog.model.google.SimpleResponseHolder
import org.rewedigital.dialog.model.google.SurfaceCapabilities


internal fun WebhookRequest.findArguments(argName: Input.Argument.ArgumentNames) =
    originalDetectIntentRequest
        ?.payload
        ?.inputs
        ?.flatMap { it.arguments.orEmpty() }
        ?.firstOrNull {
            it.name.equals(argName.name, ignoreCase = true)
        }

internal fun WebhookRequest.permissionGranted() = findArguments(PERMISSION)?.boolValue ?: false

internal fun WebhookRequest.signInStatus() = findArguments(SIGN_IN)?.extension?.status

internal fun WebhookRequest.getSelectedOption() = findArguments(OPTION)?.textValue

internal fun WebhookRequest.getSurfaceCapabilities() =
    originalDetectIntentRequest
        ?.payload
        ?.surface
        ?.capabilities
        ?.mapNotNull { capability ->
            SurfaceCapabilities.values().firstOrNull { it.capabilityName == capability.name }
        }
        .orEmpty()

internal fun WebhookRequest.hasSurfaceCapability(capability: SurfaceCapabilities) =
    getSurfaceCapabilities().contains(capability)

internal fun WebhookResponse.validate() = this.apply {
    val googlePayload = payload?.google
    if (googlePayload != null) {
        // One or both must be used
        if (googlePayload.richResponse == null && googlePayload.systemIntent == null) {
            println(googlePayload)
            throw IllegalStateException("Either RichResponse or  SystemIntent must not be null.")
        }

        val richResponse = googlePayload.richResponse
        if (richResponse != null) {
            when {
                richResponse.items.size == 0 -> {
                    println(richResponse)
                    throw IllegalStateException("RichResponse must have at least one item.")
                }
                richResponse.items.size > 3 -> {
                    println(richResponse)
                    throw IllegalStateException("RichResponse may not have more than three item.")
                }
                (richResponse.items.first() is SimpleResponseHolder).not() -> {
                    println(richResponse)
                    throw IllegalStateException("RichResponse must begin with a SimpleResponse.")
                }
            }
        }
    }
}