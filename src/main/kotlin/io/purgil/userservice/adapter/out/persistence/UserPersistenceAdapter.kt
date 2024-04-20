package io.purgil.userservice.adapter.out.persistence

import io.purgil.userservice.application.domain.mapper.UserMapper
import io.purgil.userservice.application.domain.model.User
import io.purgil.userservice.application.port.`in`.dto.RegisterCommend
import io.purgil.userservice.application.port.out.WriteUserPort
import io.purgil.userservice.application.port.out.ReadUserPort
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
        private val userJpaRepo: UserJpaRepo,
        private val userMapper: UserMapper
) : WriteUserPort, ReadUserPort {
    override fun existsByUsername(username: String): Boolean =
            userJpaRepo.existsByUsername(username)

    override fun existsByNickname(nickname: String): Boolean =
            userJpaRepo.existsByNickname(nickname)

    override fun create(user: User): User {
        return user
    }
}
