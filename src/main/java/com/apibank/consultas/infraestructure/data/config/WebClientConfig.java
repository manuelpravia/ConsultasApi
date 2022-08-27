package com.apibank.consultas.infraestructure.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("http://localhost:8088")
    private String clientApiUrl;


    @Bean
    WebClient ApiWebClient(){
        return  WebClient.create(clientApiUrl);
    }
 

}
