package org.rewedigital.dialog.springsample.alexa

import com.amazon.ask.dispatcher.request.interceptor.RequestInterceptor
import com.amazon.ask.dispatcher.request.interceptor.ResponseInterceptor
import org.rewedigital.dialog.spring.annotations.Interceptor
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class InterceptorConfig {

    data class InterceptorHolder(
        val requestInterceptors: List<RequestInterceptor>,
        val responseInterceptors: List<ResponseInterceptor>
    )

    @Bean
    fun provideInterceptorHolder(context: ApplicationContext): InterceptorHolder {

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

        return InterceptorHolder(requestInterceptors, responseInterceptors)
    }
}