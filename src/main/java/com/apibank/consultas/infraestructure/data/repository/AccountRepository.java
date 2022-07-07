package com.apibank.consultas.infraestructure.data.repository;

import com.apibank.consultas.infraestructure.data.document.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class AccountRepository {

    private final WebClient webClient;

    public  AccountRepository(@Qualifier("ApiWebClient") WebClient webClient){
        this.webClient = webClient;
    }

    public Flux<Account> getAccountByCustomerID(String idCustomer){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/accounts/consulta/{idCustomer}").build(idCustomer))
                .retrieve()
                .bodyToFlux(Account.class);
    }

}
