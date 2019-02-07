package org.rewedigital.dialog.handler

/**
 * Indicates that the class which implements the [DialogflowIntentHandler] can handle an Intent from
 * Dialogflow.
 *
 * The [DialogflowIntentHandler] will be called from the [org.rewedigital.dialog.resolver.RequestResolver].
 */
interface DialogflowIntentHandler {

    /**
     * The [org.rewedigital.dialog.resolver.RequestResolver] will call this function. Return true if this
     * [DialogflowIntentHandler] should handle the incoming request. Return false if not.
     */
    fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean

    /**
     * The [org.rewedigital.dialog.resolver.RequestResolver] will call this function if the [canHandleDialogflowIntent]
     * function has returned true.
     *
     * The logic for handling the Intent goes here. To create a response use the [DialogflowHandler.responseBuilder].
     */
    fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder?
}