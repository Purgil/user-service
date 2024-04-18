package io.purgil.userservice.application.port.out

import io.purgil.userservice.application.domain.model.User
import io.purgil.userservice.application.port.`in`.dto.RegisterCommend

interface CommendUserPort {
    fun create(commend: RegisterCommend) : User
}
