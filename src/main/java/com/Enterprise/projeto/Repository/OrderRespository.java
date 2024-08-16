package com.Enterprise.projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Enterprise.projeto.entities.Order;

@Service
public interface OrderRespository extends JpaRepository<Order, Long> {

}
