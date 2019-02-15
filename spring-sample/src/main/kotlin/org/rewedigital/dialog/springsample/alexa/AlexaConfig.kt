package org.rewedigital.dialog.springsample.alexa

import com.amazon.ask.Skill
import com.amazon.ask.builder.CustomSkillBuilder
import com.amazon.ask.services.ApacheHttpApiClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AlexaConfig {

    @Bean
    fun provideSkill(
        intentHandlerHolder: IntentHandlerConfig.IntentHandlerHolder,
        interceptorHolder: InterceptorConfig.InterceptorHolder
    ): Skill =
        CustomSkillBuilder()
            .addRequestHandlers(intentHandlerHolder.intentHandlers)
            .apply {
                interceptorHolder.requestInterceptors.forEach {
                    addRequestInterceptor(it)
                }
                interceptorHolder.responseInterceptors.forEach {
                    addResponseInterceptor(it)
                }
            }
            .withApiClient(ApacheHttpApiClient.standard())
            .build()
}