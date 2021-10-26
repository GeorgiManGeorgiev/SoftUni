package com.example.exam.repository;

import com.example.exam.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("select o from Order as o ORDER BY o.price desc ")
    List<Order> findAllOrderByPriceDesc();
}
