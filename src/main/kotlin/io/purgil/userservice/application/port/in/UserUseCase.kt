package io.purgil.userservice.application.port.`in`

import io.purgil.userservice.shared.dto.AuthUserData
import io.purgil.userservice.shared.dto.EmailRegisterCommend

interface UserUseCase {
    suspend fun emailRegister(commend: EmailRegisterCommend): AuthUserData
}
