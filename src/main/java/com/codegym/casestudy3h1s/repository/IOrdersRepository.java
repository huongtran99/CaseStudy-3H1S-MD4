package com.codegym.casestudy3h1s.repository;

import com.codegym.casestudy3h1s.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select * from orders where user_id = ?", nativeQuery = true)
    Iterable<Orders> findAllByUserId(Long id);
}
