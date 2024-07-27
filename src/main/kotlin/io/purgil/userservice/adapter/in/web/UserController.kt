package io.purgil.userservice.adapter.`in`.web

import io.purgil.userservice.application.port.`in`.UserUseCase
import io.purgil.userservice.shared.dto.AuthUserData
import io.purgil.userservice.shared.dto.EmailRegisterCommend
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
        private val userUseCase: UserUseCase
) {
    @PostMapping("/register/email")
    suspend fun register(@Valid @RequestBody commend : EmailRegisterCommend) : ResponseEntity<AuthUserData> {
        return ResponseEntity.ok(
                userUseCase.emailRegister(commend)
        )
    }
}
