package com.Enterprise.projeto.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Enterprise.projeto.entities.Category;
import com.Enterprise.projeto.service.CategoryService;

@RestController
@RequestMapping(name = "/category")
public class CategoryResources {

	@Autowired
	public CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findall(){
		return ResponseEntity.ok().body(categoryService.findAll());
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(categoryService.findById(id));
	}

}	
