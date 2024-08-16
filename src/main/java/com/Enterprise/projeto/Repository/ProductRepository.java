package com.Enterprise.projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Enterprise.projeto.entities.Product;

@Service
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
