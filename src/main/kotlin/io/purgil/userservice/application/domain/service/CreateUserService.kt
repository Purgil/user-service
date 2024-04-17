package io.purgil.userservice.application.domain.service

import io.purgil.userservice.application.domain.model.User
import io.purgil.userservice.application.port.`in`.CreateUserCommend
import io.purgil.userservice.application.port.`in`.CreateUserUseCase

class CreateUserService : CreateUserUseCase {
    override fun creatUser(commend: CreateUserCommend): User {
        TODO("Not yet implemented")
    }
}