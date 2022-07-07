package com.apibank.consultas.api;

import com.apibank.consultas.domain.dto.ClientAllProduct;
import com.apibank.consultas.domain.service.ConsultProductByCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("consultas")
public class ConsultasApi {

    @Autowired
    ConsultProductByCustomerService customerService;

    @GetMapping("/{id}")
    public Mono<ClientAllProduct> getCustomer(@PathVariable String id){
        return customerService.listAccount(id);
    }




}
