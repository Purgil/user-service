package io.purgil.userservice.domain.common

import java.time.LocalDateTime
import java.util.UUID

interface Auditable {
    val createdAt: LocalDateTime
    val createdBy: UUID
    var updatedAt: LocalDateTime
    var updatedBy: UUID
}
