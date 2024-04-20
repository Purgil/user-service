package io.purgil.userservice.application.domain.model

import lombok.Builder

@Builder
data class User(
        val id: Long,
        val username: String,
        val password: String,
        val nickname: String
) {
    companion object {
        fun of() = Builder()
    }

    class Builder {
        private var id: Long = 0L
        private var username: String = ""
        private var password: String = ""
        private var nickname: String = ""

        fun id(id: Long) = apply { this.id = id }
        fun username(username: String) = apply { this.username = username }
        fun password(password: String) = apply { this.password = password }
        fun nickname(nickname: String) = apply { this.nickname = nickname }

        fun build() = User(id, username, password, nickname)
    }


}
