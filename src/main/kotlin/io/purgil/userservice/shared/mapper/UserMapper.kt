package io.purgil.userservice.shared.mapper

import io.purgil.userservice.adapter.out.persistence.enitity.BlockEntity
import io.purgil.userservice.adapter.out.persistence.enitity.FollowEntity
import io.purgil.userservice.adapter.out.persistence.enitity.SocialProfileEntity
import io.purgil.userservice.adapter.out.persistence.enitity.UserEntity
import io.purgil.userservice.domain.model.Block
import io.purgil.userservice.domain.model.Follow
import io.purgil.userservice.domain.model.SocialProfile
import io.purgil.userservice.domain.model.User
import io.purgil.userservice.shared.dto.AuthUserData
import io.purgil.userservice.shared.mapper.UserMapper.toDomain
import java.util.*

object UserMapper {
    fun UserEntity.toDomain(): User =
        User(
                id = this.id,
                email = this.email,
                password = this.password,
                name = this.name,
                isActive = this.isActive,
                isWithdrawn = this.isWithdrawn,
                withdrawnAt = this.withdrawnAt,
                createdAt = this.createdAt,
                createdBy = this.createdBy,
                lastModifiedAt = this.lastModifiedAt,
                lastModifiedBy = this.lastModifiedBy
        )

    fun User.toEntity(): UserEntity =
        UserEntity(
                id = this.id,
                email = this.email,
                password = this.password,
                name = this.name,
                isActive = this.isActive,
                isWithdrawn = this.isWithdrawn,
                withdrawnAt = this.withdrawnAt,
                createdAt = this.createdAt,
                createdBy = this.createdBy,
                lastModifiedAt = this.lastModifiedAt,
                lastModifiedBy = this.lastModifiedBy
        )

    fun User.toAuthUserData(): AuthUserData =
        AuthUserData(
                id = this.id.toString(),
                email = this.email,
                name = this.name
        )

    fun SocialProfileEntity.toDomain(): SocialProfile =
        SocialProfile(
                id = this.id,
                socialId = this.socialId,
                socialType = this.socialType,
                additionalInfo = this.additionalInfo,
                createdAt = this.createdAt
        )

    fun SocialProfile.toEntity(): SocialProfileEntity =
        SocialProfileEntity(
                id = this.id,
                socialId = this.socialId,
                socialType = this.socialType,
                additionalInfo = this.additionalInfo,
                createdAt = this.createdAt
        )

    fun FollowEntity.toDomain(): Follow =
        Follow(
                id = this.id,
                followerId = this.followerId,
                followingId = this.followingId,
                createdAt = this.createdAt
        )

    fun Follow.toEntity(): FollowEntity =
        FollowEntity(
                id = this.id,
                followerId = this.followerId,
                followingId = this.followingId,
                createdAt = this.createdAt
        )

    fun BlockEntity.toDomain(): Block =
        Block(
                id = this.id,
                blockerId = this.blockerId,
                blockingId = this.blockingId,
                createdAt = this.createdAt
        )

    fun Block.toEntity(): BlockEntity =
        BlockEntity(
                id = this.id,
                blockerId = this.blockerId,
                blockingId = this.blockingId,
                createdAt = this.createdAt
        )
}
