package com.codegym.casestudy3h1s.service.product;

import com.codegym.casestudy3h1s.model.Product;
import com.codegym.casestudy3h1s.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    Optional<Product> findProductByCode(String code);

    Page<Product> findProductByCategoryId(Long id, Pageable pageable);

    Page<Product> findProductByNameContaining(String name, Pageable pageable);
}
