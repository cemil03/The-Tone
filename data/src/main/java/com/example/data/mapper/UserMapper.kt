package com.example.data.mapper

import com.example.data.data.entity.UserEntity
import com.example.domain.entity.User

class UserMapper : Mapper<UserEntity, User> {
    override fun mapFromEntity(entity: UserEntity): User =
        User(entity.id, entity.userName, entity.email, entity.password)

    override fun mapToEntity(model: User): UserEntity =
        UserEntity(model.id, model.userName, model.email, model.password)
}