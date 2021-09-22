package com.ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "author", indexes =  @Index(columnList = "lastName,firstName"))
public class Author extends BaseEntity{
	
	private String firstName;
	private String lastName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "co_author_book",
		joinColumns = {@JoinColumn(name = "author_id")},
		inverseJoinColumns = {@JoinColumn(name = "book_id")}
		)
	private List<Book> co_bookList = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookAuthor", cascade = CascadeType.ALL)
	private List<Book> bookList = new ArrayList<>();
}
