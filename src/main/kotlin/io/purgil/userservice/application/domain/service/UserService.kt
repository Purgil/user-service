package io.purgil.userservice.application.domain.service

import io.purgil.userservice.application.domain.model.User
import io.purgil.userservice.application.port.`in`.dto.RegisterCommend
import io.purgil.userservice.application.port.`in`.RegisterUseCase
import io.purgil.userservice.application.port.`in`.dto.UserInfo
import io.purgil.userservice.application.port.out.WriteUserPort
import io.purgil.userservice.application.port.out.ReadUserPort
import org.springframework.stereotype.Service

@Service
class UserService(
        private val commendUserPort: WriteUserPort,
        private val loadUserPort: ReadUserPort
) : RegisterUseCase{
    override fun executeRegister(commend: RegisterCommend): UserInfo {
        checkIsUsernameOrNicknameDuplicated(commend.username, commend.nickname)

        val user = User.of()
                .nickname(commend.nickname)
                .username(commend.username)
                .password(commend.password)
                .build()

        val persistedUser = commendUserPort.create(user)

        return UserInfo.from(persistedUser)
    }

    fun checkIsUsernameOrNicknameDuplicated(username: String, nickname: String) {
        if (loadUserPort.existsByUsername(username))
            throw Exception("")
        if (loadUserPort.existsByNickname(nickname))
            throw Exception("")
    }
}