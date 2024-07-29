package io.purgil.userservice.infra.config

import io.purgil.sharedlib.converter.JsonToRoleTypeListConverter
import io.purgil.sharedlib.converter.RoleTypeListToJsonConverter
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions
import org.springframework.data.r2dbc.dialect.DialectResolver
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class R2dbcConfig(
        private val connectionFactory: ConnectionFactory
) {
    @Bean
    fun r2dbcCustomConversions(): R2dbcCustomConversions {
        val dialect = DialectResolver.getDialect(connectionFactory)
        val resolvers = mutableListOf(
                JsonToRoleTypeListConverter(),
                RoleTypeListToJsonConverter()
        )
        return R2dbcCustomConversions.of(
                dialect,
                resolvers
        )
    }
}
