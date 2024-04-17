package io.purgil.userservice.adapter.out.persistence

import io.purgil.userservice.application.domain.model.User
import io.purgil.userservice.application.port.out.UserReadPort
import io.purgil.userservice.application.port.out.UserWritePort

class UserPersistenceAdapter : UserReadPort, UserWritePort {
    override fun findByUsername(username: String): User {
        TODO("Not yet implemented")
    }

    override fun create(user: User) {
        TODO("Not yet implemented")
    }
}