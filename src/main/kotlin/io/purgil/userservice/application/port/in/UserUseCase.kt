package io.purgil.userservice.application.port.`in`

import io.purgil.sharedlib.dto.LoginUser
import io.purgil.userservice.shared.dto.AuthorizationResDTO
import io.purgil.userservice.shared.dto.EmailRegisterCommend
import io.purgil.userservice.shared.dto.LoginCommend

interface UserUseCase {
    suspend fun emailRegister(commend: EmailRegisterCommend): AuthorizationResDTO
    suspend fun emailLogin(commend: LoginCommend): AuthorizationResDTO
}
