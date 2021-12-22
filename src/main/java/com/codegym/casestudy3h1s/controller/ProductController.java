package com.codegym.casestudy3h1s.controller;

import com.codegym.casestudy3h1s.model.OrderDetail;
import com.codegym.casestudy3h1s.model.Orders;
import com.codegym.casestudy3h1s.model.Product;
import com.codegym.casestudy3h1s.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> showAll(@RequestParam("main-search") Optional<String> search, @PageableDefault(size = 4) Pageable pageable) {
        if(search.isPresent()) {
            return new ResponseEntity<>(productService.findProductByNameContaining(search.get(), pageable), HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Page<Product>> showProductByCategory(@PathVariable Long id, @PageableDefault(size = 4) Pageable pageable) {
        return new ResponseEntity<>(productService.findProductByCategoryId(id, pageable), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else  {
            productService.remove(id);
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
    }

    @GetMapping("getProduct/{id}")
    public ResponseEntity<Product> getProductDetail(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if(product.getId() != null) {
                product.setId(id);
            }
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }
    }

}
