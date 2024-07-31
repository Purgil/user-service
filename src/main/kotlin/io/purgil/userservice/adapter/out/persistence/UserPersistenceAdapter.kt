package io.purgil.userservice.adapter.out.persistence

import io.purgil.userservice.application.port.out.UserPersistencePort
import io.purgil.userservice.domain.model.User
import io.purgil.userservice.infrastructure.repository.UserRepository
import io.purgil.userservice.shared.mapper.UserMapper.toDomain
import io.purgil.userservice.shared.mapper.UserMapper.toEntity
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
        private val userRepository: UserRepository,
) : UserPersistencePort {
    override suspend fun existsByEmail(email: String): Boolean =
            userRepository.existsByEmail(email)

    override suspend fun save(user: User): User =
            userRepository.save(user.toEntity())
                    .toDomain()

    override suspend fun findByEmail(email: String): User {
        val userEntity = userRepository.findByEmail(email)
                ?: throw IllegalArgumentException("User not found by email: $email")
        return userEntity.toDomain()
    }
}
