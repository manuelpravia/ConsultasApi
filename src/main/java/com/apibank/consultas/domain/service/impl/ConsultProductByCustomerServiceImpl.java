package com.apibank.consultas.domain.service.impl;

import com.apibank.consultas.domain.dto.ClientAllProduct;
import com.apibank.consultas.domain.service.ConsultProductByCustomerService;
import com.apibank.consultas.infraestructure.data.document.Account;
import com.apibank.consultas.infraestructure.data.document.Credit;
import com.apibank.consultas.infraestructure.data.document.Customer;
import com.apibank.consultas.infraestructure.data.repository.AccountRepository;
import com.apibank.consultas.infraestructure.data.repository.CreditRepository;
import com.apibank.consultas.infraestructure.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultProductByCustomerServiceImpl implements ConsultProductByCustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Mono<ClientAllProduct> listAccount(String idCustomer) {
        ClientAllProduct clientAllProduct= new ClientAllProduct();
        List<Credit> creditList = new ArrayList<>();
        List<Account> accountList = new ArrayList<>();
         customerRepository.getCustomerByID(idCustomer)
                .flatMap(customer -> {
                    clientAllProduct.setCustomer(customer);
                    creditRepository.getCreditByCustomerID(idCustomer)
                            .flatMap(credit -> {
                                creditList.add(credit);
                                return  null;
                            }).subscribe();
                    accountRepository.getAccountByCustomerID(idCustomer)
                            .flatMap(account -> {
                                accountList.add(account);
                                return  null;
                            }).subscribe();
                    return  null;
                }).subscribe();
         return Mono.just(clientAllProduct);
    }


}
