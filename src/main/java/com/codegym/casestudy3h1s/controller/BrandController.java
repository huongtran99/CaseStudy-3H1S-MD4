package com.codegym.casestudy3h1s.controller;

import com.codegym.casestudy3h1s.model.Brand;
import com.codegym.casestudy3h1s.service.brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @GetMapping
    public ResponseEntity<Iterable<Brand>> showAll() {
        return new ResponseEntity<>(brandService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Brand> addCategory(@RequestBody Brand brand) {
        return new ResponseEntity<>(brandService.save(brand), HttpStatus.CREATED);
    }
}
