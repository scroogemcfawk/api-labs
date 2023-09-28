package com.scroogemcfawk.tsu.apilabs.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.scroogemcfawk.tsu.apilabs.server.entity.UserEntity
import java.net.HttpRetryException
import java.net.URI
import java.net.URL
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.math.E

fun main() {
    val cli = HttpClient.newHttpClient()
    val resource = "http://localhost:8080"
    while (true) {
        print(">>>: ")
        val c = readln()
        when (c.lowercase()) {
            "q", "e", "quit", "exit" -> {
                println("Exiting program.")
                break
            }

            "h", "help" -> {
                println("I'm too lazy to write everything.")
            }

            "all" -> {
                try {
                    val q = HttpRequest.newBuilder(URI.create("$resource/user/all")).build()
                    val r = cli.send(q, HttpResponse.BodyHandlers.ofString())
                    if (r.statusCode() == 200) {
                        println("Users:")
                        println(r.body())
                    } else {
                        throw Exception("Something went wrong: Server status = ${r.statusCode()}")
                    }
                } catch (e: Exception) {
                    println("Error: " + e.message)
                }
            }

            "register" -> {
                try {
                    val user = HashMap<String, String>()

                    print("Username: ")
                    user["username"] = readln()
                    print("Password: ")
                    user["password"] = readln()

                    val body = jacksonObjectMapper().writeValueAsString(user)
                    println(body)
                    val q = HttpRequest.newBuilder(URI.create("$resource/user/register")).POST(HttpRequest.BodyPublishers.ofString(body))
                        .header("Content-Type", "application/json")
                        .build()
                    val r = cli.send(q, HttpResponse.BodyHandlers.ofString())
                    if (r.statusCode() != 200) throw Exception("Something went wrong: Server status = ${r.statusCode()}")
                    println(r.body())
                } catch (e: Exception) {
                    println("Error: " + e.message)
                }

            }

            else -> {
                println("Unknown command. Type 'h' for help.")
            }
        }
    }
}