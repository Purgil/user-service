package io.purgil.userservice.infra.repository

import io.purgil.userservice.adapter.out.persistence.enitity.UserEntity
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface UserRepository : CoroutineCrudRepository<UserEntity, String> {
    suspend fun existsByEmail(email: String): Boolean
    suspend fun save(userEntity: UserEntity): UserEntity
}
