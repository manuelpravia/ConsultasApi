package com.apibank.consultas.infraestructure.data.util;

import com.apibank.consultas.domain.dto.ClientAllProduct;
import com.apibank.consultas.infraestructure.data.document.Account;
import com.apibank.consultas.infraestructure.data.document.Credit;
import com.apibank.consultas.infraestructure.data.document.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClientAllProductMapper {

    ClientAllProduct ConvertToObject(Customer customer, List<Credit> credit, List<Account> account);
}
