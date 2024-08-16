package com.Enterprise.projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Enterprise.projeto.entities.especial.OrderItem;
import com.Enterprise.projeto.entitiesPk.OrdemItemPk;

@Service
public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPk> {

}
