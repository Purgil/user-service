package io.purgil.userservice.application.port.out

import io.purgil.userservice.application.domain.model.User

interface UserWritePort {
    fun create(user: User)
}