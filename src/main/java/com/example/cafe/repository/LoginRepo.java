package com.example.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafe.entity.CustomerOrder;
import com.example.cafe.entity.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login,String> {
	
}
