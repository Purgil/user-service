package io.purgil.userservice.infra.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncoderService {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun encodePassword(rawPassword: String): String {
        return passwordEncoder.encode(rawPassword)
    }

    fun matches(rawPassword: String, encodedPassword: String): Boolean {
        return passwordEncoder.matches(rawPassword, encodedPassword)
    }
}
