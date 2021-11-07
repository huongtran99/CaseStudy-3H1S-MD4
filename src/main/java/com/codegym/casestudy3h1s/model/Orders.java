package com.codegym.casestudy3h1s.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

}
