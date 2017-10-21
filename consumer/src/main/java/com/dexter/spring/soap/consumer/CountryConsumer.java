package com.dexter.spring.soap.consumer;

import com.dexter.spring.soap.consumer.model.GetCountryRequest;
import com.dexter.spring.soap.consumer.model.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CountryConsumer extends WebServiceGatewaySupport {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public GetCountryResponse getCountry(String countryName) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(countryName);

        log.info("Requesting country for " + countryName);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
                        request,
                        new SoapActionCallback("http://dexter.com/model"));

        return response;
    }

}
