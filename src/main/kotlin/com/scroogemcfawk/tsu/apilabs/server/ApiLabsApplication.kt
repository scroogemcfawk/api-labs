package com.scroogemcfawk.tsu.apilabs.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


//@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@SpringBootApplication
class ApiLabsApplication

fun main(args: Array<String>) {
    runApplication<ApiLabsApplication>(*args)
}
