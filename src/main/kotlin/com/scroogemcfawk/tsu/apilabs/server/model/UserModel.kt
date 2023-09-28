package com.scroogemcfawk.tsu.apilabs.server.model

import com.scroogemcfawk.tsu.apilabs.server.entity.UserEntity

class UserModel
private constructor(val id: Long, val username: String) {
    companion object {
        fun fromEntity(entity: UserEntity): UserModel {
            return UserModel(entity.id, entity.username)
        }
    }
}