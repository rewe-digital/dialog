package org.rewedigital.dialog.alexa


interface MultiPlatformIntentHandlerRegistry {
    fun provideIntentHandlers(): List<MultiPlatformIntentHandler>
}