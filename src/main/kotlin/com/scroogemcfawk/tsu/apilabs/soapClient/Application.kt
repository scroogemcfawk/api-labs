package com.scroogemcfawk.tsu.apilabs.soapClient

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class ConsumingWebServiceApplication {

    @Bean
    open fun lookup(quoteClient: CountryClient): CommandLineRunner {
        return CommandLineRunner { args: Array<String?> ->
            var country: String? = "Spain"
            if (args.isNotEmpty()) {
                country = args[0]
            }
            val response = quoteClient.getCountry(
                country!!
            )
            System.err.println(response.country.currency)
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ConsumingWebServiceApplication::class.java, *args)
}