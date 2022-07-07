package com.apibank.consultas.infraestructure.data.repository;

import com.apibank.consultas.infraestructure.data.document.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CustomerRepository {

    private  final WebClient webClient;

    public  CustomerRepository(@Qualifier("ApiWebClient") WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<Customer> getCustomerByID(String id){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/customers/{id}").build(id))
                .retrieve()
                .bodyToMono(Customer.class);
    }

}
