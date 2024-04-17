package io.purgil.userservice.application.port.out

import io.purgil.userservice.application.domain.model.User

interface UserReadPort {
    fun findByUsername(username: String): User
}