package io.purgil.userservice.shared.dto

import io.purgil.sharedlib.util.RegexPattern
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class EmailRegisterCommend(
        @NotNull
        @Email
        val email: String,

        @NotNull
        @Size(min = 6, max = 20)
        val name: String,

        @NotNull
        @Size(min = 6, max = 20)
        @Pattern(regexp = RegexPattern.PASSWORD)
        val password: String,
)

data class LoginCommend(
        @NotNull
        @Email
        val email: String,

        @NotNull
        @Size(min = 6, max = 20)
        @Pattern(regexp = RegexPattern.PASSWORD)
        val password: String,
)
