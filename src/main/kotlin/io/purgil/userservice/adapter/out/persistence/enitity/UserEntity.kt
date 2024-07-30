package io.purgil.userservice.adapter.out.persistence.enitity

import io.purgil.userservice.domain.vo.SocialType
import io.r2dbc.postgresql.codec.Json
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table(name = "\"user\"")
data class UserEntity(
        @Id val id: UUID? = null,
        val email: String,
        val password: String?,
        val name: String,
        val isActive: Boolean,
        @Column("roles") val roles: Json,
        val isWithdrawn: Boolean,
        val withdrawnAt: LocalDateTime?,
        @CreatedBy val createdBy: String? = null,
        @CreatedDate val createdAt: LocalDateTime? = null,
        @LastModifiedBy val lastModifiedBy: String? = null,
        @LastModifiedDate val lastModifiedAt: LocalDateTime? = null
)

@Table(name = "social_profile")
data class SocialProfileEntity(
        @Id val id: UUID? = null,
        val userId: UUID,
        val socialId: String,
        val socialType: SocialType,
        val additionalInfo: Map<String, Any> = emptyMap(),
        @CreatedDate val createdAt: LocalDateTime? = null,
)

@Table(name = "follow")
data class FollowEntity(
        @Id val id: Long? = null,
        val followerId: UUID,
        val followingId: UUID,
        @CreatedDate val createdAt: LocalDateTime? = null,
)

@Table(name = "block")
data class BlockEntity(
        @Id val id: Long? = null,
        val blockerId: UUID,
        val blockingId: UUID,
        @CreatedDate val createdAt: LocalDateTime? = null,
)
