package com.apibank.consultas.domain.service.impl;

import com.apibank.consultas.domain.dto.ClientAllProduct;
import com.apibank.consultas.domain.service.ConsultProductByCustomerService;
import com.apibank.consultas.infraestructure.data.document.Customer;
import com.apibank.consultas.infraestructure.data.repository.AccountRepository;
import com.apibank.consultas.infraestructure.data.repository.CreditRepository;
import com.apibank.consultas.infraestructure.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


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
        return customerRepository.getCustomerByID(idCustomer)
                .zipWhen(cutomer -> accountRepository.getAccountByCustomerID(idCustomer).collectList())
                .zipWhen(t -> creditRepository.getCreditByCustomerID(idCustomer).collectList() )
                .map(result ->{
                    ClientAllProduct clientAllProduct = new ClientAllProduct();
                    Customer x = result.getT1().getT1();
                    clientAllProduct.setId(x.getId());
                    clientAllProduct.setName(x.getName());
                    clientAllProduct.setAddress(x.getAddress());
                    clientAllProduct.setPhone(x.getPhone());
                    clientAllProduct.setType(x.getType());
                    clientAllProduct.setAccounts(result.getT1().getT2());
                    clientAllProduct.setCredits(result.getT2());
                    return clientAllProduct;
                });


    }

}
