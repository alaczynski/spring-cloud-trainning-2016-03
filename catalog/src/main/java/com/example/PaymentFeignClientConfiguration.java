package com.example;

import feign.Logger;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ExcludeFromComponentScan
@Configuration
public class PaymentFeignClientConfiguration {

    public PaymentFeignClientConfiguration() {
        System.out.println("xxx - PaymentFeignClientConfiguration created");
    }

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }

    @Bean
    PaymentServiceFallback paymentServiceFallback() {
        return new PaymentServiceFallback();
    }

    @Bean
    ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            if (response.status() == INTERNAL_SERVER_ERROR.value()) {
                throw new RetryableException("retry", null);
            } else {
                return new ErrorDecoder.Default().decode(methodKey, response);
            }
        };
    }
}
