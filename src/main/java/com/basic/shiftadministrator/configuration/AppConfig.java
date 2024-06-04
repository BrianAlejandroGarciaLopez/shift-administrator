package com.basic.shiftadministrator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean("apiConsume")
    public RestTemplate restTemplateRegister(){
        return new RestTemplate();
    }
}
