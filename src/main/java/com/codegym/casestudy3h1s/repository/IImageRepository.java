package com.codegym.casestudy3h1s.repository;

import com.codegym.casestudy3h1s.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {
}
