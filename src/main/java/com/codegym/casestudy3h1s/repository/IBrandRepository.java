package com.codegym.casestudy3h1s.repository;

import com.codegym.casestudy3h1s.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends JpaRepository<Brand,Long> {
}
