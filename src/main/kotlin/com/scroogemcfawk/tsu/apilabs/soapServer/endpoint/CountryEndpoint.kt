package com.scroogemcfawk.tsu.apilabs.soapServer.endpoint

import com.scroogemcfawk.tsu.apilabs.soapServer.repo.CountryRepository
import io.spring.guides.gs_producing_web_service.GetCountryRequest
import io.spring.guides.gs_producing_web_service.GetCountryResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class CountryEndpoint @Autowired constructor(private val countryRepository: CountryRepository) {

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    fun getCountry(@RequestPayload request: GetCountryRequest): GetCountryResponse {
        val response = GetCountryResponse()
        response.country = countryRepository.findCountry(request.name)
        return response
    }

    companion object {

        private const val NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service"
    }
}