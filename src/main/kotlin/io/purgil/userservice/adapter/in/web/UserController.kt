package io.purgil.userservice.adapter.`in`.web

import io.purgil.sharedlib.resorver.dto.LoginUser
import io.purgil.userservice.application.port.`in`.UserUseCase
import io.purgil.userservice.shared.dto.EmailRegisterCommend
import io.purgil.userservice.shared.dto.LoginCommend
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
    suspend fun register(@Valid @RequestBody commend: EmailRegisterCommend): ResponseEntity<LoginUser> =
            ResponseEntity.ok(
                    userUseCase.emailRegister(commend)
            )

    @PostMapping("/login/email")
    suspend fun login(@Valid @RequestBody commend: LoginCommend): ResponseEntity<LoginUser> =
            ResponseEntity.ok(
                    userUseCase.emailLogin(commend)
            )
}
