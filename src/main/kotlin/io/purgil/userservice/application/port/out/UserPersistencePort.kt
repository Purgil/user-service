package io.purgil.userservice.application.port.out

import io.purgil.userservice.domain.model.User

interface UserPersistencePort {
    suspend fun existsByEmail(email: String): Boolean
    suspend fun save(user: User) : User
}
