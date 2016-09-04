package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${payment.service.name}", configuration = PaymentFeignClientConfiguration.class, fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @RequestMapping(value = "/payments", method = RequestMethod.POST)
    PaymentStatus payments();
}
