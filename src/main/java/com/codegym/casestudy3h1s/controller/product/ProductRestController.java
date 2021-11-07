package com.codegym.casestudy3h1s.controller.product;

import com.codegym.casestudy3h1s.model.dto.ProductForm;
import com.codegym.casestudy3h1s.model.entity.Image;
import com.codegym.casestudy3h1s.model.entity.Product;
import com.codegym.casestudy3h1s.service.image.ImageService;
import com.codegym.casestudy3h1s.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ImageService imageService;

    @Value("${file-upload}")
    private String fileUpload;


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
    public ResponseEntity<Product> create(ProductForm productForm) throws IOException {
        List<Image> imageList = new ArrayList<>();
        List<MultipartFile> multipartFile = productForm.getFileImages();
        for (MultipartFile multipartFile1: multipartFile) {
            Image image = new Image();
            String filename = multipartFile1.getOriginalFilename();
            FileCopyUtils.copy(multipartFile1.getBytes(), new File(fileUpload + new Date().getTime() + filename));
            image.setFileImage(filename);
            imageList.add(image);
            imageService.save(image);
        }
        Product product = new Product(
                productForm.getName(),
                productForm.getCode(),
                productForm.getDescription(),
                productForm.getPrice(),
                productForm.getAmount(),
                productForm.getCategory(),
                productForm.getBrand(),
                productForm.getDiscount(),
                imageList
        );
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
    public ResponseEntity<Product> update(@PathVariable Long id, ProductForm productForm) throws IOException {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            List<Image> imageList = new ArrayList<>();
            List<MultipartFile> multipartFile = productForm.getFileImages();
            for (MultipartFile multipartFile1: multipartFile) {
                Image image = new Image();
                String filename = multipartFile1.getOriginalFilename();
                FileCopyUtils.copy(multipartFile1.getBytes(), new File(fileUpload + new Date().getTime() + filename));
                image.setFileImage(filename);
                imageList.add(image);
                imageService.save(image);
            }
            Product product = new Product(
                    productForm.getName(),
                    productForm.getCode(),
                    productForm.getDescription(),
                    productForm.getPrice(),
                    productForm.getAmount(),
                    productForm.getCategory(),
                    productForm.getBrand(),
                    productForm.getDiscount(),
                    imageList
            );
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

    @GetMapping("/{id}/images")
    public ResponseEntity<Iterable<Image>> findImageByProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(imageService.findAllByProduct(productOptional.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}



