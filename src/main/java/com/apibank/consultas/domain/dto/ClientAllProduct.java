package com.apibank.consultas.domain.dto;

import com.apibank.consultas.infraestructure.data.document.Account;
import com.apibank.consultas.infraestructure.data.document.Credit;
import com.apibank.consultas.infraestructure.data.document.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientAllProduct {
    private Customer customer;
    private List<Credit> credits;
    private List<Account> accounts;
}
