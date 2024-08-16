package com.Enterprise.projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Enterprise.projeto.entities.Category;

@Service
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
