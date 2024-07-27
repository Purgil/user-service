package io.purgil.userservice

data class AuthenticationUser(
        val id: String,
        val email: String,
        val name: String,
        val roles: List<String>,
)
