package com.codegym.casestudy3h1s.model.entity;

import com.codegym.casestudy3h1s.model.entity.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private int amount;

    public Cart(Long id, User user, Product product, int amount) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.amount = amount;
    }

    public Cart() {
    }

    public Cart(User user, Product product, int amount) {
        this.user = user;
        this.product = product;
        this.amount = amount;
    }
}
