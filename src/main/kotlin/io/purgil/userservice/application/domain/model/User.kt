package io.purgil.userservice.application.domain.model

data class User(
        val id: Long ,
        val username: String,
        val email: String,
        val password: String
)
