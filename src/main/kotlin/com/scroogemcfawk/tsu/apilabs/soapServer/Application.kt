package com.scroogemcfawk.tsu.apilabs.soapServer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class ProducingWebServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(ProducingWebServiceApplication::class.java, *args)
}