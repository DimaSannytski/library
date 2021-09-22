package com.ua.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookCreateDto {

	private String title;
	
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publicationDate;
	
	private long authorId;
	
	private long genreId;
	
	private int copyCount;
}
