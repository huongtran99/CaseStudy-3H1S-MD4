package com.codegym.casestudy3h1s.model.dto;

import com.codegym.casestudy3h1s.model.entity.Brand;
import com.codegym.casestudy3h1s.model.entity.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;
import java.util.List;

@Data
public class ProductForm {
    private Long id;

    private String name;

    private String code;

    private String description;

    private double price;

    private int amount;

    private Category category;

    private Brand brand;

    private double discount;

    private List<MultipartFile> fileImages;
}
