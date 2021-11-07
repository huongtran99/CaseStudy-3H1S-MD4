package com.codegym.casestudy3h1s.repository;

import com.codegym.casestudy3h1s.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
