package com.apibank.consultas.infraestructure.data.document;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Credit {
    private String id;
    private String type;
    private BigDecimal amount;
    private LocalDateTime date;
    private List<String> customers;
    private Long dayAmortize;
    private List<String> dateAmortize;
}
