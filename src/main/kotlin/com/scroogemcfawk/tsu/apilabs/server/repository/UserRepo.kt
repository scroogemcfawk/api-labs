package com.scroogemcfawk.tsu.apilabs.server.repository

import com.scroogemcfawk.tsu.apilabs.server.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepo: CrudRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
}