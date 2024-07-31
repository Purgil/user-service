package io.purgil.userservice.shared.dto

data class AuthorizationResDTO(
        val accessToken: String,
        val refreshToken: String
)
