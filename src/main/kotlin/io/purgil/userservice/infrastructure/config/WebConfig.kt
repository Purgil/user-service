package io.purgil.userservice.infrastructure.config

import io.purgil.sharedlib.resorver.LoginUserArgumentResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer

@Configuration
class WebConfig(
        private val loginUserArgumentResolver: LoginUserArgumentResolver
) : WebFluxConfigurer  {
    override fun configureArgumentResolvers(configurer: ArgumentResolverConfigurer) {
        configurer.addCustomResolver(loginUserArgumentResolver)
    }
}
