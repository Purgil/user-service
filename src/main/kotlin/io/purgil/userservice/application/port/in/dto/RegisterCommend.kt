package io.purgil.userservice.application.port.`in`.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class RegisterCommend(
        @NotNull
        @Size(min = 6, max = 20)
        val username: String,

        @NotNull
        @Size(min = 6, max = 20)
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?]).{6,}$")
        val password: String,

        @NotNull
        @Size(min = 2, max = 20)
        val nickname: String
)
