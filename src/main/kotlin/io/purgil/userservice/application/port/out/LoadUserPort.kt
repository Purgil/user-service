package io.purgil.userservice.application.port.out

interface LoadUserPort {
    fun existsByUsername(username: String): Boolean
    fun existsByNickname(nickname: String): Boolean
}