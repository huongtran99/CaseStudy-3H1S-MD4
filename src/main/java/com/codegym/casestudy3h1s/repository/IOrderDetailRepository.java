package com.codegym.casestudy3h1s.repository;

import com.codegym.casestudy3h1s.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select * from order_detail join orders o on order_detail.order_id = o.id where o.user_id = ?", nativeQuery = true)
    Iterable<OrderDetail> findAllByUserId(Long id);
}
