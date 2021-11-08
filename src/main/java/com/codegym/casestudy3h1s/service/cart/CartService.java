package com.codegym.casestudy3h1s.service.cart;

import com.codegym.casestudy3h1s.model.entity.Cart;
import com.codegym.casestudy3h1s.model.entity.user.User;
import com.codegym.casestudy3h1s.repository.cart.ICartRepository;
import com.codegym.casestudy3h1s.service.user.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private IUserService userService;

    @Override
    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Page<Cart> findAll(Pageable pageable) {
        return cartRepository.findAll(pageable);
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void remove(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Iterable<Cart> findAllByUser(User user) {
        return cartRepository.findAllByUser(user);
    }
}
