package com.ua.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "book_copy")
public class BookCopy extends BaseEntity{
	
	@ManyToOne
	private Book book;
	
	@ManyToOne 
	private BookStatus bookStatus;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bookCopy")
	private List<BookOrder> bookOrders;
}
