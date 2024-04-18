package io.purgil.userservice.common.validation

import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validation
import jakarta.validation.Validator

class Validation {
    private val validator: Validator =
            Validation.buildDefaultValidatorFactory().validator

    fun <T> validate(subject: T) {
        val violations : Set<ConstraintViolation<T>>  = validator.validate(subject)
        if (violations.isNotEmpty()) {
            throw ConstraintViolationException(violations)
        }
    }
}