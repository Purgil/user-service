package io.purgil.userservice.shared.mapper

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.r2dbc.postgresql.codec.Json

object JsonMapper {
    private val objectMapper = jacksonObjectMapper()

    fun <T> fromJson(json: Json, valueType: Class<T>): T {
        return objectMapper.readValue(json.asString(), valueType)
    }

    fun toJson(value: Any): Json {
        return Json.of(objectMapper.writeValueAsString(value))
    }
}
