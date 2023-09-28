package com.scroogemcfawk.tsu.apilabs.server.service

import com.scroogemcfawk.tsu.apilabs.server.entity.UserEntity
import com.scroogemcfawk.tsu.apilabs.server.model.UserModel
import com.scroogemcfawk.tsu.apilabs.server.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userRepo: UserRepo

    fun register(user: UserEntity): UserEntity {
        if (userRepo.findByUsername(user.username) == null) {
            return userRepo.save(user)
        }
        throw Exception("User already exists.")
    }

    fun delete(id: Long) {
        return userRepo.deleteById(id)
    }

    private fun getAll(): Iterable<UserEntity> {
        return userRepo.findAll()
    }

    fun getAllAsModel(): Iterable<UserModel> {
        val models = ArrayList<UserModel>()
        getAll().forEach { models.add(UserModel.fromEntity(it)) }
        return models
    }
}