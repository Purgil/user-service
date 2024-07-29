package io.purgil.userservice.application.service

import io.purgil.sharedlib.resorver.dto.LoginUser
import io.purgil.userservice.application.port.`in`.UserUseCase
import io.purgil.userservice.application.port.out.UserPersistencePort
import io.purgil.userservice.domain.service.UserDomainService
import io.purgil.userservice.infra.security.Encoder
import io.purgil.userservice.shared.dto.EmailRegisterCommend
import io.purgil.userservice.shared.dto.LoginCommend
import io.purgil.userservice.shared.mapper.UserMapper.toLoginUser
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userDomainService: UserDomainService,
        private val userPersistencePort: UserPersistencePort,
        private val encoder: Encoder
) : UserUseCase{
    override suspend fun emailRegister(commend: EmailRegisterCommend): LoginUser {
        if (userPersistencePort.existsByEmail(commend.email))
            throw IllegalArgumentException("Email already exists")
        val pwdEncodedCommend = commend.copy(
                password = encoder.encode(commend.password)
        )
        val registeredUser = userDomainService.emailRegister(pwdEncodedCommend)

        return userPersistencePort.save(registeredUser)
                .toLoginUser()
    }

    override suspend fun emailLogin(commend: LoginCommend): LoginUser {
        val user = userPersistencePort.findByEmail(commend.email)
        if (!encoder.matches(commend.password, user.password!!))
            throw IllegalArgumentException("이메일 비밀번호를 다시 확인해 주세요")

        return user.toLoginUser()
    }
}
