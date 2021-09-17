package com.ua.mapper;

import com.ua.dto.BookCreateDto;
import com.ua.dto.BookDto;
import com.ua.entity.Book;

public interface BookMapper {

	public static Book createDtoToBook(BookCreateDto bookCreateDto){
		Book book = new Book();
		book.setTitle(bookCreateDto.getTitle());
		book.setDescription(bookCreateDto.getDescription());
		book.setPublicationDate(bookCreateDto.getPublicationDate());
		return book;
	}
	public static BookDto bookToDto(Book book) {
		BookDto bookDto = new BookDto();
		bookDto.setTitle(book.getTitle());
		bookDto.setDescription(book.getDescription());
		bookDto.setPublicationDate(book.getPublicationDate());
		return bookDto;
	}
}
