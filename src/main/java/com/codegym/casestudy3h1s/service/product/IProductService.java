package com.codegym.casestudy3h1s.service.product;

import com.codegym.casestudy3h1s.model.entity.Product;
import com.codegym.casestudy3h1s.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}
