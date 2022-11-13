package com.example.data.mapper

interface Mapper<EntityDB,Entity> {
    fun mapFromEntity(entity: EntityDB) : Entity
    fun mapToEntity(model: Entity) : EntityDB
}