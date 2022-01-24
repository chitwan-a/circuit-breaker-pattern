package com.designpattern.clientcode;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@org.springframework.stereotype.Service
public class Service {

    private RestTemplate restTemplate;

    public Service(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "reliable",
            commandProperties = {
                    @HystrixProperty(
                            name= "circuitBreaker.requestVolumeThreshold",
                            value="6"),
                    @HystrixProperty(
                            name= "circuitBreaker.sleepWindowInMilliseconds",
                            value="10000"),
                    @HystrixProperty(
                            name= "circuitBreaker.enabled",
                            value = "false")
            } )
    public String readingList() {
        URI uri = URI.create("http://localhost:8090/all");
        return this.restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return "Dummy";
    }
}
