package com.pera.springtest.service;

import com.pera.springtest.repository.ICustomerRepository;
import com.pera.springtest.repository.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final ICustomerRepository repository;

    public Customer save(String name, String address, String phone){
      if(repository.findAll().stream().filter(x-> x.getName().equals(name)).count()>0)
            throw new IllegalArgumentException("The customer is already exist");
      Customer customer = repository.save(Customer.builder()
              .name(name)
              .address(address)
              .phone(phone)
              .build());
      return  customer;
    }

    public boolean findByCustomerId(Long id){
        return repository.existsById(id);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
