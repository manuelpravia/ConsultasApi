package com.apibank.consultas.infraestructure.data.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    private String id;
    private String name;
    private String address;
    private String phone;
    private  String type;
}
