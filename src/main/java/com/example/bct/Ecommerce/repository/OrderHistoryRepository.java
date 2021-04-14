package com.example.bct.Ecommerce.repository;

import com.example.bct.Ecommerce.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long > {
    List<OrderHistory> findAllByUserId(Long id);
}
