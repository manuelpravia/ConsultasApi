package com.apibank.consultas.infraestructure.data.document;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class Account {
    private String id;
    private String numAccount;
    private BigDecimal maintenance;
    private int maxMovement;
    private String type;
    private BigDecimal availableBalance;
    private List<String> customers;
}
