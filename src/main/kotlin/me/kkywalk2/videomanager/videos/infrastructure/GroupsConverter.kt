package me.kkywalk2.videomanager.videos.infrastructure

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class GroupsConverter: AttributeConverter<List<GroupAttribute>, String> {
    override fun convertToDatabaseColumn(attribute: List<GroupAttribute>): String {
        return jacksonObjectMapper().writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String): List<GroupAttribute> {
        return jacksonObjectMapper().readValue(dbData, object : TypeReference<List<GroupAttribute>>() {})
    }
}