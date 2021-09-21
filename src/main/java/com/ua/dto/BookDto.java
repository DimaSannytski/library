package com.ua.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class BookDto {


	private String title;
	
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publicationDate;
}
