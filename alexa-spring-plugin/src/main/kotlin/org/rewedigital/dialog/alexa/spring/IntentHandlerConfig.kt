package org.rewedigital.dialog.alexa.spring

import com.amazon.ask.dispatcher.request.handler.RequestHandler
import org.rewedigital.dialog.spring.annotations.IntentHandler
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.instrument.IllegalClassFormatException


@Configuration
class IntentHandlerConfig {

    data class IntentHandlerHolder(val intentHandlers: List<RequestHandler>)

    @Bean
    fun provideIntentHandlerHolder(context: ApplicationContext): IntentHandlerHolder {

        val allIntentHandler =
            context
                .getBeanNamesForAnnotation(IntentHandler::class.java)
                .map {
                    context.getBean(it) as? RequestHandler
                        ?: throw IllegalClassFormatException("Your IntentHandler must implement the interface MultiPlatformIntentHandler")
                }

        return IntentHandlerHolder(allIntentHandler)
    }
}