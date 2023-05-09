package com.pera.springtest.service;


import com.pera.springtest.repository.ISaleRepository;
import com.pera.springtest.repository.entity.Sale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SaleServiceTest {

    @InjectMocks
    private SaleService saleService;

    @Mock
    private ISaleRepository repository;
    @Mock
    private CustomerService customerService;

    @Test
    void save() throws Exception {
        /**
         * satiş içinde findByCustomerId methodu çağım yapıldığı için buraya gönderilen
         * id ile çağrıma cevap vermek doğrudur.
         */
        Mockito.when(customerService.findByCustomerId(1L)).thenReturn(true);
        Mockito.when(repository.save(ArgumentMatchers.any(Sale.class))).thenReturn(Sale.builder()
                        .id(1L)
                        .price(32D)
                        .totalPrice(320D)
                        .customerId(1L)
                        .quantity(10)
                        .product("sugar")
                .build());
       Long id = saleService.sale(1L,"sugar",32D,10);
       Assertions.assertNotNull(id);
    }

    @Test
    void saveCustomerReturnExceptionNotExist(){
        Assertions.assertThrows(Exception.class,()->{
            saleService.sale(1L,"",0D,0);
        });
    }

    @Test
    void saveCustomerWhilePriceAndQuantityNotProper(){
        Mockito.when(customerService.findByCustomerId(1L)).thenReturn(true);
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            saleService.sale(1L,"",0D,0);
        });
    }
}
