package com.scroogemcfawk.tsu.apilabs.soapClient

import com.scroogemcfawk.tsu.apilabs.soapClient.wsdl.GetCountryRequest
import com.scroogemcfawk.tsu.apilabs.soapClient.wsdl.GetCountryResponse
import org.slf4j.LoggerFactory
import org.springframework.ws.client.core.support.WebServiceGatewaySupport
import org.springframework.ws.soap.client.core.SoapActionCallback

class CountryClient: WebServiceGatewaySupport() {

    fun getCountry(country: String): GetCountryResponse {
        val request = GetCountryRequest()
        request.name = country
        log.info("Requesting location for $country")
        return webServiceTemplate.marshalSendAndReceive(
                "http://localhost:8080/ws/countries", request, SoapActionCallback(
                    "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"
                )
            ) as GetCountryResponse
    }

    companion object {
        private val log = LoggerFactory.getLogger(CountryClient::class.java)
    }
}