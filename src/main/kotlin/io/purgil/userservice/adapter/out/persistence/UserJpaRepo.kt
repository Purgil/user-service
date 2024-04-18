package io.purgil.userservice.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepo : JpaRepository<UserJpaEntity, Long> {
    fun existsByUsername(username: String) : Boolean
    fun existsByNickname(nickname: String) : Boolean
}