package com.ua.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ua.entity.enums.Role;
import com.ua.entity.enums.Sex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person", indexes =  @Index(columnList = "email,firstName"))
public class User extends BaseEntity{

	private String firstName;
	
	private String lastName;
	
	private String password;

	@Column(name = "email", unique = true)
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reader")
	private List<BookOrder> bookOrders;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
	private List<BookOrder> ManagingBookOrders;
	
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean isActivated;
	
	private Date birthday;
}
