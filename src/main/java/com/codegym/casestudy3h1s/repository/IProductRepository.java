package com.codegym.casestudy3h1s.repository;

import com.codegym.casestudy3h1s.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from products where code = ?", nativeQuery = true)
    Optional<Product> findProductByCode(String code);

    @Query(value = "select * from products join category c on products.category_id = c.id where c.id = ?", nativeQuery = true)
    Page<Product> findProductByCategoryId(Long id, Pageable pageable);

/*    @Query(value = "select * from products where name like %:?%", nativeQuery = true)*/
    Page<Product> findProductByNameContaining(String name, Pageable pageable);
}
