package com.scroogemcfawk.tsu.apilabs.soapClient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller

@Configuration
open class CountryConfiguration {

    @Bean
    open fun marshaller(): Jaxb2Marshaller {
        val marshaller = Jaxb2Marshaller()
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.contextPath = "com.scroogemcfawk.tsu.apilabs.soapClient.wsdl"
//        marshaller.setPackagesToScan("")
        return marshaller
    }

    @Bean
    open fun countryClient(marshaller: Jaxb2Marshaller?): CountryClient {
        val client = CountryClient()
        client.defaultUri = "http://localhost:8080/ws"
        client.marshaller = marshaller
        client.unmarshaller = marshaller
        return client
    }
}