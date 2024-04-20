package io.purgil.userservice.application.port.`in`.dto

import io.purgil.userservice.application.domain.model.User

data class UserInfo (
        val id: Long ,
        val username: String,
        val nickname: String
) {
    companion object {
        fun from (user: User): UserInfo = UserInfo(user.id, user.username, user.nickname)
    }
}
