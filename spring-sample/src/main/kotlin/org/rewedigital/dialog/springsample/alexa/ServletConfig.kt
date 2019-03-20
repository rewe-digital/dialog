package org.rewedigital.dialog.springsample.alexa

import com.amazon.ask.Skill
import com.amazon.ask.servlet.SkillServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServletConfig {

    @Bean
    fun provideAlexaSkillServlet(skill: Skill) =
        ServletRegistrationBean(SkillServlet(skill), "/alexaIntent")
}