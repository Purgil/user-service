package io.purgil.userservice.domain.service

import io.purgil.sharedlib.vo.RoleType
import io.purgil.userservice.domain.model.User
import io.purgil.userservice.shared.dto.EmailRegisterCommend
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserDomainService {
    fun emailRegister(commend: EmailRegisterCommend): User =
            User(
                    email = commend.email,
                    name = commend.name,
                    password = commend.password,
                    roles = listOf(RoleType.MEMBER),
            )
}
