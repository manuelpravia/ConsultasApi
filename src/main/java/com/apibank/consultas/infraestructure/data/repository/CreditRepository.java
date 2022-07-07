package com.apibank.consultas.infraestructure.data.repository;

import com.apibank.consultas.infraestructure.data.document.Credit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class CreditRepository {

    private  final  WebClient webClient;

    public  CreditRepository(@Qualifier("ApiWebClient") WebClient webClient){
        this.webClient = webClient;
    }

    public Flux<Credit> getCreditByCustomerID(String idCustomer){
        return  webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/credits/creditcustomer/{idCustomer}").build(idCustomer))
                .retrieve()
                .bodyToFlux(Credit.class);
    }
}
