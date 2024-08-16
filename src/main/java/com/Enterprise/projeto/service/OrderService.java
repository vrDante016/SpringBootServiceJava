package com.Enterprise.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Enterprise.projeto.Repository.OrderRespository;
import com.Enterprise.projeto.entities.Order;
import com.Enterprise.projeto.entities.Product;
import com.Enterprise.projeto.service.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRespository orderRespository;
	
	public List<Order> findAll(){
		return orderRespository.findAll();
	}
	public Order findById(Long id){
		Optional<Order> order = orderRespository.findById(id);
		return order.get();
	}
	
}
