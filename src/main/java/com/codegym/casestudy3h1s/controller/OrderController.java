package com.codegym.casestudy3h1s.controller;

import com.codegym.casestudy3h1s.model.Orders;
import com.codegym.casestudy3h1s.model.User;
import com.codegym.casestudy3h1s.service.order.IOrderService;
import com.codegym.casestudy3h1s.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Iterable<Orders>> showAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Orders> addOrder(@RequestBody Orders orders) {
        return new ResponseEntity<>(orderService.save(orders), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> editOrder(@PathVariable Long id, @RequestBody Orders orders) {
        Optional<Orders> ordersOptional = orderService.findById(id);
        if(!ordersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if(orders.getId() != null) {
                orders.setId(id);
            }
            return new ResponseEntity<>(orderService.save(orders), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable Long id) {
        Optional<Orders> ordersOptional = orderService.findById(id);
        if(!ordersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else  {
            orderService.remove(id);
            return new ResponseEntity<>(ordersOptional.get(), HttpStatus.OK);
        }
    }

    @DeleteMapping("all/{id}")
    public void deleteAllOrder(@PathVariable Long id) {
        Iterable<Orders> orders = orderService.findAllByUserId(id);
        orderService.removeAll(orders);
    }

}
