package com.example.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafe.entity.Login;
import com.example.cafe.entity.OrderItem;
@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {
	
}
