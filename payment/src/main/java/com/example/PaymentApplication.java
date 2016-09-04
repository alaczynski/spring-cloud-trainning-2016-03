package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class PaymentApplication {

    private Logger logger = LoggerFactory.getLogger(PaymentApplication.class);
    private int counter;

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @RequestMapping(value = "/payments", method = RequestMethod.POST)
    public ResponseEntity<PaymentStatus> payments() throws InterruptedException {
        counter++;
        logger.info("payments " + counter);
        System.out.println("payments " + counter);
        if (counter % 2 != 0) {
            Thread.sleep(5000);
            return new ResponseEntity<>(new PaymentStatus("OK"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new PaymentStatus("OK"), HttpStatus.CREATED);
    }
}
