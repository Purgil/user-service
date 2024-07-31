package io.purgil.userservice.domain.model

import io.purgil.sharedlib.vo.RoleType
import io.purgil.userservice.domain.vo.SocialType
import java.time.LocalDateTime
import java.util.UUID

data class User(
        val id: UUID? = null,
        val email: String,
        var password: String?,
        var name: String,
        var isActive: Boolean = false,
        val roles: List<RoleType> = mutableListOf(),
        val socialProfiles: List<SocialProfile> = mutableListOf(),
        val followers: List<Follow> = mutableListOf(),
        val followings: List<Follow> = mutableListOf(),
        val blockers: List<Block> = mutableListOf(),
        val blockings: List<Block> = mutableListOf(),
        var isWithdrawn: Boolean = false,
        var withdrawnAt: LocalDateTime? = null,
        val createdAt: LocalDateTime? = LocalDateTime.now(),
        val createdBy: String? = null,
        var lastModifiedAt: LocalDateTime? = LocalDateTime.now(),
        var lastModifiedBy: String? = null,
)

data class SocialProfile(
        val id: UUID? = null,
        val userId: UUID,
        val socialId: String,
        val socialType: SocialType,
        val additionalInfo: Map<String, Any> = emptyMap(),
        val createdAt: LocalDateTime? = LocalDateTime.now(),
)

data class Follow(
        val id: Long? = null,
        val followerId: UUID,
        val followingId: UUID,
        val createdAt: LocalDateTime? = LocalDateTime.now()
)

data class Block(
        val id: Long? = null,
        val blockerId: UUID,
        val blockingId: UUID,
        val createdAt: LocalDateTime? = LocalDateTime.now()
)
