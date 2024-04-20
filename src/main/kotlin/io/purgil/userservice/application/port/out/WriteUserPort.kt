package io.purgil.userservice.application.port.out

import io.purgil.userservice.application.domain.model.User

interface WriteUserPort {
    fun create(user: User) : User
}
