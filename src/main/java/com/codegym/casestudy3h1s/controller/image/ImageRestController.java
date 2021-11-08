package com.codegym.casestudy3h1s.controller.image;

import com.codegym.casestudy3h1s.model.entity.Image;
import com.codegym.casestudy3h1s.model.entity.Product;
import com.codegym.casestudy3h1s.service.image.ImageService;
import com.codegym.casestudy3h1s.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/image")
public class ImageRestController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<Page<Image>> getAllImage(@PageableDefault(size = 5) Pageable pageable) {
        Page<Image> images = imageService.findAll(pageable);
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Image> createImage(@RequestBody Image image) {
        return new ResponseEntity<>(imageService.save(image),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImage(@PathVariable Long id, @RequestBody Image image) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (imageOptional.isPresent()) {
            return new ResponseEntity<>(imageOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image image) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (imageOptional.isPresent()) {
            image.setId(id);
            return new ResponseEntity<>(imageService.save(image), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Image> deleteImage(@PathVariable Long id) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (imageOptional.isPresent()) {
            imageService.remove(id);
            return new ResponseEntity<>(imageOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
