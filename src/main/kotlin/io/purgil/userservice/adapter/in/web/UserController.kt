package io.purgil.userservice.adapter.`in`.web

import io.purgil.userservice.application.port.`in`.RegisterUseCase
import io.purgil.userservice.application.port.`in`.dto.RegisterCommend
import io.purgil.userservice.application.port.`in`.dto.UserInfo
import jakarta.validation.executable.ValidateOnExecution
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
        private val registerUseCase: RegisterUseCase
) {
    @ValidateOnExecution
    @PostMapping("/register")
    fun register(@RequestBody commend : RegisterCommend) : ResponseEntity<UserInfo> {
        val userInfo = registerUseCase.executeRegister(commend)
        return ResponseEntity.ok(userInfo)
    }
}
