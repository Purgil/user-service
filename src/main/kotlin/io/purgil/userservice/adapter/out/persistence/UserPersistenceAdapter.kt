package io.purgil.userservice.adapter.out.persistence

import io.purgil.userservice.application.port.out.UserPersistencePort
import io.purgil.userservice.domain.model.User
import io.purgil.userservice.infra.repository.UserRepository
import io.purgil.userservice.shared.mapper.UserMapper.toDomain
import io.purgil.userservice.shared.mapper.UserMapper.toEntity
import kotlinx.coroutines.reactive.awaitFirstOrElse
import kotlinx.coroutines.reactive.awaitFirstOrNull
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
}
