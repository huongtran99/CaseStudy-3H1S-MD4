package com.codegym.casestudy3h1s.controller.product;

import com.codegym.casestudy3h1s.model.entity.Product;
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
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@RequestParam(name = "q", required = false) Optional<String> q, @PageableDefault(size = 5) Pageable pageable) {
        Page<Product> pages;
        if (!q.isPresent()) {
            pages = productService.findAll(pageable);
        } else {
            pages = productService.findAllByNameContaining(q.get(), pageable);
        }
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct (@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            product.setId(id);
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            productService.remove(id);
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



