package com.ua.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "genre", indexes = @Index(columnList = "title"))
public class Genre extends BaseEntity{
	
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Book> books;
}
