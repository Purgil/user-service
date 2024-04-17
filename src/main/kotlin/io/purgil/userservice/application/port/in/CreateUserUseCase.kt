package io.purgil.userservice.application.port.`in`

import io.purgil.userservice.application.domain.model.User

interface CreateUserUseCase {
    fun creatUser(commend: CreateUserCommend): User
}
