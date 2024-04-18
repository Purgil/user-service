package io.purgil.userservice.application.domain.service

import io.purgil.userservice.application.port.`in`.dto.RegisterCommend
import io.purgil.userservice.application.port.`in`.RegisterUseCase
import io.purgil.userservice.application.port.`in`.dto.UserInfo
import io.purgil.userservice.application.port.out.CommendUserPort
import io.purgil.userservice.application.port.out.LoadUserPort
import org.springframework.stereotype.Service

@Service
class UserService(
        private val commendUserPort: CommendUserPort,
        private val loadUserPort: LoadUserPort
) : RegisterUseCase{
    override fun executeRegister(commend: RegisterCommend): UserInfo {
        checkIsUsernameOrNicknameDuplicated(commend.username, commend.nickname)
        val user = commendUserPort.create(commend)
        return UserInfo.of(user)
    }

    fun checkIsUsernameOrNicknameDuplicated(username: String, nickname: String) {
        if (loadUserPort.existsByUsername(username))
            throw Exception("")
        if (loadUserPort.existsByNickname(nickname))
            throw Exception("")
    }
}