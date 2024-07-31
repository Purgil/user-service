package io.purgil.userservice.infrastructure.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class Encoder {
    private val encoder = BCryptPasswordEncoder()

    fun encode(raw: String): String = encoder.encode(raw)

    fun matches(rawPassword: String, encodedPassword: String): Boolean =
            encoder.matches(rawPassword, encodedPassword)
}
