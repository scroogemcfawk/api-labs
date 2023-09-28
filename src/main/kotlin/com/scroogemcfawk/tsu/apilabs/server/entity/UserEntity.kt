package com.scroogemcfawk.tsu.apilabs.server.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class UserEntity(@Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 var id: Long,
                 var username: String,
                 var password: String) {

}