package com.codegym.casestudy3h1s.controller;

import com.codegym.casestudy3h1s.model.OrderDetail;
import com.codegym.casestudy3h1s.service.orderdetail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/details")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<Iterable<OrderDetail>> showAll() {
        return new ResponseEntity<>(orderDetailService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Iterable<OrderDetail>> getOrderDetail(@PathVariable Long id) {
        Iterable<OrderDetail> orderDetails = orderDetailService.findAllByUserId(id);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @DeleteMapping("all/{id}")
    public void deleteAllOrderDetailByUserId(@PathVariable Long id) {
        Iterable<OrderDetail> orderDetails = orderDetailService.findAllByUserId(id);
        orderDetailService.removeAll(orderDetails);
    }

    @PostMapping
    public ResponseEntity<OrderDetail> addOrderDetail(@RequestBody OrderDetail orderDetail) {
        return new ResponseEntity<>(orderDetailService.save(orderDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> editOrderDetail(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {
        Optional<OrderDetail> orderDetailOptional = orderDetailService.findById(id);
        if(!orderDetailOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if(orderDetail.getId() != null) {
                orderDetail.setId(id);
            }
            return new ResponseEntity<>(orderDetailService.save(orderDetail), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDetail> deleteOrderDetail(@PathVariable Long id) {
        Optional<OrderDetail> orderDetailOptional = orderDetailService.findById(id);
        if(!orderDetailOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else  {
            orderDetailService.remove(id);
            return new ResponseEntity<>(orderDetailOptional.get(), HttpStatus.OK);
        }
    }
}
