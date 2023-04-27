package com.example.cafe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafe.entity.CustomerOrder;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,Long> {
	List<CustomerOrder> findByUserName(String customerId);
}
