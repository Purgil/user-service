package io.purgil.userservice.domain.service

import io.purgil.userservice.domain.model.User
import io.purgil.userservice.shared.dto.EmailRegisterCommend
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserDomainService {
    fun emailRegister(commend: EmailRegisterCommend): User {
        val id = UUID.randomUUID()
        return User(
                id = id,
                email = commend.email,
                name = commend.name,
                password = commend.password,
                createdBy = id,
                updatedBy = id
        )
    }
}
