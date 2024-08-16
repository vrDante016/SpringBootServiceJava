package com.Enterprise.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Enterprise.projeto.Repository.CategoryRepository;
import com.Enterprise.projeto.entities.Category;
import com.Enterprise.projeto.service.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
