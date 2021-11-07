package com.codegym.casestudy3h1s.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private Orders order;

    @ManyToOne
    private Product product;

}
