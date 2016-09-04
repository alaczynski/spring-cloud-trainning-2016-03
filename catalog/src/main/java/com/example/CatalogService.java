package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

@RestController
public class CatalogService {

    private final DiscoveryClient discoveryClient;
    private final PaymentService paymentService;
    private final RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    public CatalogService(DiscoveryClient discoveryClient, PaymentService paymentService, RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.paymentService = paymentService;
        this.restTemplate = restTemplate;
    }

    @RequestMapping(path = "/orders", method = RequestMethod.POST)
    public Order orders(@RequestBody String body) {
        logger.info("orders " + body);
//        PaymentStatus paymentStatus = restTemplate.postForObject("http://payment/payments", "request", PaymentStatus.class);
        PaymentStatus paymentStatus = paymentService.payments();
        return new Order(1, body, paymentStatus.getStatus());
    }
}
