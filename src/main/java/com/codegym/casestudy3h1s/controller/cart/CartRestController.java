package com.codegym.casestudy3h1s.controller.cart;

import com.codegym.casestudy3h1s.model.entity.Cart;
import com.codegym.casestudy3h1s.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/carts")
public class CartRestController {
    @Autowired
    private ICartService cartService;

    @GetMapping
    public ResponseEntity<Iterable<Cart>> getAll(Pageable pageable) {
        return new ResponseEntity<>(cartService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.save(cart), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Optional<Cart> cartOptional = cartService.findById(id);
        if (cartOptional.isPresent()) {
            return new ResponseEntity<>(cartOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        Optional<Cart> cartOptional = cartService.findById(id);
        if (cartOptional.isPresent()) {
            cart.setId(id);
            return new ResponseEntity<>(cartService.save(cart), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable Long id) {
        Optional<Cart> cartOptional = cartService.findById(id);
        if (cartOptional.isPresent()) {
            cartService.remove(id);
            return new ResponseEntity<>(cartOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
