package com.example.cafe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafe.entity.Login;
import com.example.cafe.entity.Payment;

@Repository
public interface PaymentRepo  extends JpaRepository<Payment,Long> {
	Optional<Payment> findByOrderId(long orderId);
	List<Payment> findByCustomerId(String userName);
}

