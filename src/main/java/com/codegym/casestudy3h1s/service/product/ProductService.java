package com.codegym.casestudy3h1s.service.product;

import com.codegym.casestudy3h1s.model.Product;
import com.codegym.casestudy3h1s.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProductByCode(String code) {
        return productRepository.findProductByCode(code);
    }

    @Override
    public Page<Product> findProductByCategoryId(Long id, Pageable pageable) {
        return productRepository.findProductByCategoryId(id, pageable);
    }

    @Override
    public Page<Product> findProductByNameContaining(String name, Pageable pageable) {
        return productRepository.findProductByNameContaining(name, pageable);
    }
}
