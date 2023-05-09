package com.pera.springtest.service;

import com.pera.springtest.repository.ISaleRepository;
import com.pera.springtest.repository.entity.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final ISaleRepository repository;
    private final CustomerService customerService;
    public Long sale(Long customerId,String product, Double price,int quantity) throws Exception {
        if(!customerService.findByCustomerId(customerId))
            throw  new Exception("The customer is not exist.");
        if(quantity>0 && price> 0){
         Sale sale =  repository.save(Sale.builder()
                            .quantity(quantity)
                            .price(price)
                            .product(product)
                            .date(System.currentTimeMillis())
                            .customerId(customerId)
                            .totalPrice(price*quantity)
                    .build());
         return sale.getId();
        }else
            throw new IllegalArgumentException("Please enter proper quantity and price");
    }

}
