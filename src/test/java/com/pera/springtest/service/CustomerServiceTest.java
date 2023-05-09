package com.pera.springtest.service;

import com.pera.springtest.repository.ICustomerRepository;
import com.pera.springtest.repository.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;
    /**
     * Bir method ve Mock olarak yaratılan sınıfların içinde kullanılan tüm bağımlılıklar null olarak döner.
     * çünkü onlar için Mock nesneleri ek bir işlem yapmaz. Bu nedenle bağımlılığı olan tüm bileşenleri
     * tanımlamak ve inject etmek zorundasınız.
     */
    @Mock
    private ICustomerRepository repository;
    @Test
    void save(){
     when(repository.findAll()).thenReturn(new ArrayList<>());
     when(repository.save(ArgumentMatchers.any(Customer.class))).thenReturn(
             Customer.builder()
                     .id(1L)
                     .name("John")
                     .address("Istanbul")
                     .phone("0 555 666 9987")
                     .build()
     );
     Customer customer = customerService.save("John","Istanbul","0 555 666 9987");
     assertNotNull(customer.getId(), "While saving the customer, vale of Id has been returned NULL");
    }
    @Test
    void saveAdVarIse(){
        when(repository.findAll()).thenReturn(Arrays.asList(Customer.builder()
                .id(1L)
                .name("John")
                .address("Istanbul")
                .phone("0 555 666 9987")
                .build()));

        assertThrows(IllegalArgumentException.class,()->{
            customerService.save("John","Istanbul","0 555 666 9987");
        });
    }
}
