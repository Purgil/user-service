package io.purgil.userservice.application.service

import io.purgil.userservice.application.port.`in`.UserUseCase
import io.purgil.userservice.application.port.out.UserPersistencePort
import io.purgil.userservice.domain.service.UserDomainService
import io.purgil.userservice.infra.security.PasswordEncoderService
import io.purgil.userservice.shared.dto.AuthUserData
import io.purgil.userservice.shared.dto.EmailRegisterCommend
import io.purgil.userservice.shared.mapper.UserMapper.toAuthUserData
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userDomainService: UserDomainService,
        private val userPersistencePort: UserPersistencePort,
        private val passwordEncoderService: PasswordEncoderService
) : UserUseCase{
    override suspend fun emailRegister(commend: EmailRegisterCommend): AuthUserData {
        if (userPersistencePort.existsByEmail(commend.email))
            throw IllegalArgumentException("Email already exists")
        val pwdEncodedCommend = commend.copy(
                password = passwordEncoderService.encodePassword(commend.password)
        )
        val registeredUser = userDomainService.emailRegister(pwdEncodedCommend)

        return userPersistencePort.save(registeredUser)
                .toAuthUserData()
    }
}
