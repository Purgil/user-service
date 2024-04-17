package io.purgil.userservice.application.port.`in`

data class CreateUserCommend(
        val username: String,
        val email: String,
        val password: String
)
