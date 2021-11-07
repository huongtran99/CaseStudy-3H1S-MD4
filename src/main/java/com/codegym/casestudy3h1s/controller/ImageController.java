package com.codegym.casestudy3h1s.controller;

import com.codegym.casestudy3h1s.model.Image;
import com.codegym.casestudy3h1s.model.ImageForm;
import com.codegym.casestudy3h1s.model.Product;
import com.codegym.casestudy3h1s.service.image.IImageService;
import com.codegym.casestudy3h1s.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private IImageService imageService;

    @Autowired
    private IProductService productService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping
    public ResponseEntity<Iterable<Image>> showImages() {
        return new ResponseEntity<>(imageService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Image> addImage(Product product, ImageForm imageForm) {
        Optional<Product> productOptional = productService.findProductByCode(product.getCode());
        List<MultipartFile> multipartFile = imageForm.getFileImage();
        for (MultipartFile file : multipartFile) {
            String fileName = file.getOriginalFilename();
            try {
                FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image image = new Image();
            image.setFileImage(fileName);
            image.setProduct(productOptional.get());
            imageService.save(image);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
