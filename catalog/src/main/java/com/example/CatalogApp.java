package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(excludeFilters = @Filter(value = ExcludeFromComponentScan.class))
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableConfigurationProperties
public class CatalogApp {

    public static void main(String[] args) {
        SpringApplication.run(CatalogApp.class, args);
    }
}
