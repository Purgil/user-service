package io.purgil.userservice.application.domain.model

data class User(
        val id: Long,
        val username: String,
        val password: String,
        val nickname: String
)
