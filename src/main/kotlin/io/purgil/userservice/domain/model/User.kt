package io.purgil.userservice.domain.model

import io.purgil.userservice.domain.common.Auditable
import io.purgil.userservice.domain.vo.SocialType
import java.time.LocalDateTime
import java.util.UUID

data class User(
        val id: UUID = UUID.randomUUID(),
        val email: String,
        var password: String?,
        var name: String,
        var isActive: Boolean = false,
        val socialProfiles: List<SocialProfile> = mutableListOf(),
        val followers: List<Follow> = mutableListOf(),
        val followings: List<Follow> = mutableListOf(),
        val blockers: List<Block> = mutableListOf(),
        val blockings: List<Block> = mutableListOf(),
        var isWithdrawn: Boolean = false,
        var withdrawnAt: LocalDateTime? = null,
        override val createdAt: LocalDateTime = LocalDateTime.now(),
        override val createdBy: UUID,
        override var updatedAt: LocalDateTime = LocalDateTime.now(),
        override var updatedBy: UUID,
) : Auditable

data class SocialProfile(
        val id: UUID = UUID.randomUUID(),
        val socialId: String,
        val socialType: SocialType,
        val additionalInfo: Map<String, Any> = emptyMap(),
        val createdAt: LocalDateTime = LocalDateTime.now(),
)

data class Follow(
        val id: UUID = UUID.randomUUID(),
        val followerId: UUID,
        val followingId: UUID,
        val createdAt: LocalDateTime = LocalDateTime.now()
)

data class Block(
        val id: UUID = UUID.randomUUID(),
        val blockerId: UUID,
        val blockingId: UUID,
        val createdAt: LocalDateTime = LocalDateTime.now()
)
