package com.ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public class OrderStatus extends BaseEntity {

	private String title;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderStatus")
	private List<BookOrder> bookOrders  = new ArrayList<>();
}
