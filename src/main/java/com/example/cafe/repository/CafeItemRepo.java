package com.example.cafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafe.entity.CafeCombo;
import com.example.cafe.entity.CafeItems;
import com.example.cafe.entity.Login;
@Repository
public interface CafeItemRepo  extends JpaRepository<CafeItems,Long> {
	Optional<CafeItems> findByName (String name);
}

