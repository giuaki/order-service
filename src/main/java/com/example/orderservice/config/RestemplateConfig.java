package com.example.orderservice.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate= new RestTemplate();

        DefaultUriBuilderFactory builderFactory= new DefaultUriBuilderFactory("http://user-service/users");
        restTemplate.setUriTemplateHandler(builderFactory);
        return restTemplate;
    }
}
