package com.apibank.consultas.infraestructure.data.util;

import com.apibank.consultas.domain.dto.ClientAllProduct;
import com.apibank.consultas.infraestructure.data.document.Account;
import com.apibank.consultas.infraestructure.data.document.Credit;
import com.apibank.consultas.infraestructure.data.document.Customer;

import java.util.List;

public class ClientAllProductMaperImpl implements ClientAllProductMapper{
    @Override
    public ClientAllProduct ConvertToObject(Customer customer, List<Credit> credit, List<Account> account) {
        ClientAllProduct clientAllProduct = new ClientAllProduct();

        clientAllProduct.setCustomer(customer);
        clientAllProduct.setAccounts(account);
        clientAllProduct.setCredits(credit);
        return null;
    }

}
