package com.scroogemcfawk.tsu.apilabs.server.controller

import com.scroogemcfawk.tsu.apilabs.server.entity.UserEntity
import com.scroogemcfawk.tsu.apilabs.server.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @PostMapping("/register")
    fun register(@RequestBody user: UserEntity): ResponseEntity<String> {
        return try {
            userService.register(user)
            ResponseEntity.ok("User has been saved.")
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(e.message)
        }
    }
    @DeleteMapping("/delete")
    fun delete(@RequestParam id: Long): ResponseEntity<String> {
        return try {
            userService.delete(id)
            ResponseEntity.ok("User has been deleted.")
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @GetMapping("/all")
    fun getAllUsers(): ResponseEntity<Any> {
        return try {
            return ResponseEntity.ok(userService.getAllAsModel())
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(e.message)
        }
    }
}