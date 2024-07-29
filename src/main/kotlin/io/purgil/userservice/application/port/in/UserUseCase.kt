package io.purgil.userservice.application.port.`in`

import io.purgil.sharedlib.resorver.dto.LoginUser
import io.purgil.userservice.shared.dto.EmailRegisterCommend
import io.purgil.userservice.shared.dto.LoginCommend

interface UserUseCase {
    suspend fun emailRegister(commend: EmailRegisterCommend): LoginUser
    suspend fun emailLogin(commend: LoginCommend): LoginUser
}
