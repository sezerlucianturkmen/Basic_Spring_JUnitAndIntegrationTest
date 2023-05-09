package com.pera.springtest.controller;

import com.pera.springtest.dto.CustomerSaveDto;
import com.pera.springtest.repository.entity.Customer;
import com.pera.springtest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody CustomerSaveDto dto){
        customerService.save(dto.getName(),dto.getAddress(),dto.getPhone());
        return ResponseEntity.ok(true);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Customer>> findAll(){
        return  ResponseEntity.ok(customerService.findAll());
    }
}
