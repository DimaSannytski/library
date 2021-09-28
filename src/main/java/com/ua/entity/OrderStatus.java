package com.ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ua.entity.enums.OrderStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_status", indexes = @Index(columnList = "title"))
public class OrderStatus extends BaseEntity{

	private String title;
	
	@Enumerated(EnumType.STRING)
	private OrderStatusEnum orderStatusEnum;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderStatus")
	private List<BookOrder> bookOrders  = new ArrayList<>();
	

}
