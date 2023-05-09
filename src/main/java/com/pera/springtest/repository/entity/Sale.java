package com.pera.springtest.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblsale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long customerId;
    String product;
    Double price;
    int quantity;
    Double totalPrice;
    Long date;

}
