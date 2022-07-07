package com.apibank.consultas.domain.service;

import com.apibank.consultas.domain.dto.ClientAllProduct;
import com.apibank.consultas.infraestructure.data.document.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ConsultProductByCustomerService {

    Mono<ClientAllProduct> listAccount(String id);
}
