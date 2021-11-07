package com.codegym.casestudy3h1s.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ImageForm {

    private Long id;

    private List<MultipartFile> fileImage;

    private Product product;
}
