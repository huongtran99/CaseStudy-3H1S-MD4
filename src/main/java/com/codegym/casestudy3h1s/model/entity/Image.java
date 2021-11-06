package com.codegym.casestudy3h1s.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileImage;

    @ManyToOne
    private Product product;
}
