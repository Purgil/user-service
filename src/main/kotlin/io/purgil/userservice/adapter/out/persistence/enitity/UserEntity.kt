package io.purgil.userservice.adapter.out.persistence.enitity

import io.purgil.userservice.domain.common.Auditable
import io.purgil.userservice.domain.model.Block
import io.purgil.userservice.domain.model.Follow
import io.purgil.userservice.domain.model.SocialProfile
import io.purgil.userservice.domain.vo.SocialType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table(name = "user")
data class UserEntity(
        @Id
        val id: UUID = UUID.randomUUID(),
        val email: String,
        val password: String?,
        val name: String,
        val isActive: Boolean,
        val socialProfiles: List<SocialProfileEntity> = listOf(),
        val followers: List<FollowEntity> = listOf(),
        val followings: List<FollowEntity> = listOf(),
        val blockers: List<BlockEntity> = listOf(),
        val blockings: List<BlockEntity> = listOf(),
        val isWithdrawn: Boolean,
        val withdrawnAt: LocalDateTime?,
        override val createdAt: LocalDateTime,
        override val createdBy: UUID,
        override var updatedAt: LocalDateTime,
        override var updatedBy: UUID,
) : Auditable

@Table(name = "socoal_profile")
data class SocialProfileEntity(
        @Id
        val id: UUID = UUID.randomUUID(),
        val socialId: String,
        val socialType: SocialType,
        val additionalInfo: Map<String, Any> = emptyMap(),
        val createdAt: LocalDateTime,
)

@Table(name = "follow")
data class FollowEntity(
        @Id
        val id: UUID = UUID.randomUUID(),
        val followerId: UUID,
        val followingId: UUID,
        val createdAt: LocalDateTime
)

@Table(name = "block")
data class BlockEntity(
        @Id
        val id: UUID = UUID.randomUUID(),
        val blockerId: UUID,
        val blockingId: UUID,
        val createdAt: LocalDateTime
)
