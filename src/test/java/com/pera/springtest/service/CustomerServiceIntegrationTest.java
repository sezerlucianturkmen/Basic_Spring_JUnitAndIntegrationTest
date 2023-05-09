package com.pera.springtest.service;

import com.pera.springtest.repository.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Gerçek ortam testi yapılacağı için, spring in ayağa kalkması gereklidir. bu nedenle bu
 * anotasyon eklenir.
 */
@SpringBootTest
@ActiveProfiles("test")
public class CustomerServiceIntegrationTest {
    /**
     * Birim test, tüm methodların dış etmenlerden uzak soytlanarak kontrol edildiği test yöntemi dir.
     * bu test için kullanılan tüm bileşenler sanal nesneler olduğu için DB işlemleri gibi işlemler
     * yapılmaz.
     * Itagration Test, gerçek sistem üzerinde tüm nesnelerin gerçek nesne olarak yaratıldığı sistemin
     * işleyişinin kontrol edildiği testlerdir.
     */
    @Autowired
    private CustomerService customerService;

    @Test
    void save(){
     Customer customer = customerService.save("John","Istanbul","0 555 999 7744");
     Assertions.assertNotNull(customer.getId());
     System.out.println(customer.toString());
    }



}
