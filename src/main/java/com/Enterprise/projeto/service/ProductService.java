package com.Enterprise.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Enterprise.projeto.Repository.ProductRepository;
import com.Enterprise.projeto.entities.Product;
import com.Enterprise.projeto.resources.exceptions.ResourceExceptionHandler;
import com.Enterprise.projeto.service.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id); 
		return product.get();
	}
	
	
}
