package com.ua.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name = "book_order")
public class BookOrder extends BaseEntity{
	
	@Column(name = "return_time")
	private Date returnTime;
	
	@Column(name = "epected_return_time")
	private Date expectedReturnTime;
	
	@Column(name = "person_take_at")
	private Date personTakeAt;
	
	@ManyToOne
	private OrderStatus orderStatus;
	
	@ManyToOne
	private User reader;
	
	@ManyToOne
	private BookCopy bookCopy;
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private User manager;
}
