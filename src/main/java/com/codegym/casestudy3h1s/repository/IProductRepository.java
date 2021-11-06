package com.codegym.casestudy3h1s.repository;

import com.codegym.casestudy3h1s.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
