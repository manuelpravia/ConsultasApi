package com.apibank.consultas.infraestructure.data.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movement {
    private  String id;
    private String type;
    private String date;
    private BigDecimal amount;
    private String idAccount;
}
