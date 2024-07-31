package io.purgil.userservice.infrastructure.repository

import io.purgil.userservice.adapter.out.persistence.enitity.UserEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository : CoroutineCrudRepository<UserEntity, String> {
    suspend fun findByEmail(email: String): UserEntity?
    suspend fun existsByEmail(email: String): Boolean
    suspend fun save(userEntity: UserEntity): UserEntity
}
