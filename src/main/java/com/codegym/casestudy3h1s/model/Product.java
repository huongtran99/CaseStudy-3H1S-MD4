package com.codegym.casestudy3h1s.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private String description;

    private double price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    private double discount;
}
