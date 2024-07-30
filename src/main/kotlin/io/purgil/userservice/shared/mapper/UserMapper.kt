package io.purgil.userservice.shared.mapper

import io.purgil.sharedlib.resorver.dto.LoginUser
import io.purgil.sharedlib.vo.RoleType
import io.purgil.userservice.adapter.out.persistence.enitity.BlockEntity
import io.purgil.userservice.adapter.out.persistence.enitity.FollowEntity
import io.purgil.userservice.adapter.out.persistence.enitity.SocialProfileEntity
import io.purgil.userservice.adapter.out.persistence.enitity.UserEntity
import io.purgil.userservice.domain.model.Block
import io.purgil.userservice.domain.model.Follow
import io.purgil.userservice.domain.model.SocialProfile
import io.purgil.userservice.domain.model.User

object UserMapper {
    fun UserEntity.toDomain(): User =
        User(
                id = this.id,
                email = this.email,
                password = this.password,
                name = this.name,
                isActive = this.isActive,
                roles = JsonMapper.fromJson(this.roles, Array<RoleType>::class.java).toList(),
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
                roles = JsonMapper.toJson(this.roles),
                isWithdrawn = this.isWithdrawn,
                withdrawnAt = this.withdrawnAt,
                createdAt = this.createdAt,
                createdBy = this.createdBy,
                lastModifiedAt = this.lastModifiedAt,
                lastModifiedBy = this.lastModifiedBy
        )

    fun User.toLoginUser(): LoginUser =
            LoginUser(
                id = this.id!!,
                email = this.email,
                name = this.name,
                roles = this.roles
        )

    fun SocialProfileEntity.toDomain(): SocialProfile =
        SocialProfile(
                id = this.id,
                userId = this.userId,
                socialId = this.socialId,
                socialType = this.socialType,
                additionalInfo = this.additionalInfo,
                createdAt = this.createdAt
        )

    fun SocialProfile.toEntity(): SocialProfileEntity =
        SocialProfileEntity(
                id = this.id,
                userId = this.userId,
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
