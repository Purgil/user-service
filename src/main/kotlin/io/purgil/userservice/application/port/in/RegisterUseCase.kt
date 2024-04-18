package io.purgil.userservice.application.port.`in`

import io.purgil.userservice.application.port.`in`.dto.RegisterCommend
import io.purgil.userservice.application.port.`in`.dto.UserInfo
import io.purgil.userservice.common.UseCase

@UseCase
interface RegisterUseCase {
    fun executeRegister(commend: RegisterCommend): UserInfo
}
