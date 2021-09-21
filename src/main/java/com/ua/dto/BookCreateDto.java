package com.ua.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BookCreateDto {

	private String title;
	
	private String description;
	
	private Date publicationDate;
}