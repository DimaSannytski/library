package com.ua.mapper;

import com.ua.dto.BookCreateDto;
import com.ua.dto.BookDto;
import com.ua.entity.Book;
import com.ua.service.AuthorService;
import com.ua.service.GenreService;

public interface BookMapper {

	public static Book createDtoToBook(BookCreateDto bookCreateDto, AuthorService authorService, 
			GenreService genreService){
		Book book = new Book();
		book.setTitle(bookCreateDto.getTitle());
		book.setDescription(bookCreateDto.getDescription());
		book.setPublicationDate(bookCreateDto.getPublicationDate());
		book.setBookAuthor(authorService.getAuthorById(bookCreateDto.getAuthorId()));
		book.setGenre(genreService.getGenreById(bookCreateDto.getGenreId()));

		
		return book;
	}
	public static BookDto bookToDto(Book book) {
		
		BookDto bookDto = new BookDto();
		bookDto.setTitle(book.getTitle());
		bookDto.setDescription(book.getDescription());
		bookDto.setPublicationDate(book.getPublicationDate());
		
		if(book.getBookAuthor() != null) {
			bookDto.setAuthorFirstName(book.getBookAuthor().getFirstName());
			bookDto.setAuthorLastName(book.getBookAuthor().getLastName());
		}
		
		if (book.getGenre() != null) {
			bookDto.setGenre(book.getGenre().getTitle());
		}

		bookDto.setAvailableCopys(book.getBookCopies().size());
		
		return bookDto;
	}
}
