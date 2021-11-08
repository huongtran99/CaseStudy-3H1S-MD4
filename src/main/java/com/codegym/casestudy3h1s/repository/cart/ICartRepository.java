package com.codegym.casestudy3h1s.repository.cart;

import com.codegym.casestudy3h1s.model.entity.Cart;
import com.codegym.casestudy3h1s.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
    Iterable<Cart> findAllByUser(User user);
}
