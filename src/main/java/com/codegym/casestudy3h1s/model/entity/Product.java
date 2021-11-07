package com.codegym.casestudy3h1s.model.entity;

import com.codegym.casestudy3h1s.model.entity.Brand;
import com.codegym.casestudy3h1s.model.entity.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private String description;

    private double price;

    private int amount;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    private double discount;

    @OneToMany
    private List<Image> image;

    public Product(Long id, String name, String code, String description, double price, int amount, Category category, Brand brand, double discount, List<Image> image) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.brand = brand;
        this.discount = discount;
        this.image = image;
    }

    public Product(String name, String code, String description, double price, int amount, Category category, Brand brand, double discount, List<Image> image) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.brand = brand;
        this.discount = discount;
        this.image = image;
    }
}