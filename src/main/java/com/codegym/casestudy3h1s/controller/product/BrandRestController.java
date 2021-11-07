package com.codegym.casestudy3h1s.controller.product;

import com.codegym.casestudy3h1s.model.entity.Brand;
import com.codegym.casestudy3h1s.service.brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandRestController {

    @Autowired
    private IBrandService brandService;

    @GetMapping
    public ResponseEntity<Iterable<Brand>> getAllBrands() {
        Iterable<Brand> brands = brandService.findAll();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        return new ResponseEntity<>(brandService.save(brand), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrand(@PathVariable Long id) {
        Optional<Brand> brandOptional = brandService.findById(id);
        if (brandOptional.isPresent()) {
            return new ResponseEntity<>(brandOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        Optional<Brand> brandOptional = brandService.findById(id);
        if (brandOptional.isPresent()) {
            brand.setId(id);
            return new ResponseEntity<>(brandService.save(brand),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Brand> deleteBrand(@PathVariable Long id) {
        Optional<Brand> brandOptional = brandService.findById(id);
        if (brandOptional.isPresent()) {
            brandService.remove(id);
            return new ResponseEntity<>(brandOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
