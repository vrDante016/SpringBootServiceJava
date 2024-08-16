package com.Enterprise.projeto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.hibernate.annotations.GeneratorType;

import com.Enterprise.projeto.entities.especial.OrderItem;
import com.Enterprise.projeto.entities.especial.Payment;
import com.Enterprise.projeto.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Users client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {
		
	}
	public Order(Long id, Instant moment, Users users, OrderStatus orderStatus) {
		this.id = id;
		this.moment = moment;
		this.client = users;
		setOrderStatus(orderStatus);
		
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public void setUsers(Users users) {
		this.client = users;
	}
	public void setItens(Set<OrderItem> itens) {
		this.itens = itens;
	}
	public Long getId() {
		return id;
	}
	public Instant getMoment() {
		return moment;
	}
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Set<OrderItem> getItens() {
		return itens;
	}
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	public Users getUsers() {
		return client;
	}
	public Set<OrderItem> geItems(){
		return itens;
	}
	
	public Double total() {
		double sum = 0.0;
		for(OrderItem o : itens) {
			sum +=  o.subTotal();
		}
		return sum;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
}
