package io.purgil.userservice.application.port.out

interface ReadUserPort {
    fun existsByUsername(username: String): Boolean
    fun existsByNickname(nickname: String): Boolean
}