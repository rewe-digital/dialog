package org.rewedigital.dialog.spring

import org.rewedigital.dialog.handler.DialogflowIntentHandler
import org.rewedigital.dialog.interceptors.RequestInterceptor
import org.rewedigital.dialog.interceptors.ResponseInterceptor
import org.rewedigital.dialog.resolver.RequestResolver
import org.rewedigital.dialog.spring.annotations.FallbackIntentHandler
import org.rewedigital.dialog.spring.annotations.IntentHandler
import org.rewedigital.dialog.spring.annotations.Interceptor
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.instrument.IllegalClassFormatException


@Configuration
class RequestResolverConfig(private val context: ApplicationContext) {

    @Bean
    fun provideRequestResolver(): RequestResolver {

        val allIntentHandler =
            context
                .getBeanNamesForAnnotation(IntentHandler::class.java)
                .map {
                    context.getBean(it) as? DialogflowIntentHandler
                        ?: throw IllegalClassFormatException("Your IntentHandler must implement the interface DialogflowIntentHandler")
                }

        val fallbackIntentHandler =
            context
                .getBeanNamesForAnnotation(FallbackIntentHandler::class.java)
                .apply {
                    if (size > 1) {
                        throw IllegalStateException("Only one FallbackIntentHandler allowed!")
                    }
                }
                .firstOrNull()
                .run {
                    if (this == null) {
                        throw IllegalStateException("You must provide one FallbackIntentHandler!")
                    }

                    (context.getBean(this) as? DialogflowIntentHandler)
                        ?: throw IllegalClassFormatException("Your IntentHandler must implement the interface DialogflowIntentHandler")
                }

        val requestInterceptors = mutableListOf<RequestInterceptor>()
        val responseInterceptors = mutableListOf<ResponseInterceptor>()

        context.getBeanNamesForAnnotation(Interceptor::class.java)
            .forEach { beanName ->
                context.getBean(beanName)
                    .also { bean ->
                        if (bean is RequestInterceptor) {
                            requestInterceptors.add(bean)
                        }
                        if (bean is ResponseInterceptor) {
                            responseInterceptors.add(bean)
                        }
                    }
            }

        return RequestResolver(
            intentHandlers = allIntentHandler,
            fallbackAction = fallbackIntentHandler::handleDialogflowIntent,
            requestInterceptors = requestInterceptors,
            responseInterceptors = responseInterceptors
        )
    }
}