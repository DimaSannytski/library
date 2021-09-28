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
	
	public static BookCreateDto getEdtBookModel(Book book) {
		BookCreateDto bookCreateDto = new BookCreateDto();
		if (book.getBookAuthor() != null) {
			bookCreateDto.setAuthorId(book.getBookAuthor().getId());
		}
		if (book.getGenre() != null) {
			bookCreateDto.setGenreId(book.getGenre().getId());
		}
		bookCreateDto.setTitle(book.getTitle());
		bookCreateDto.setDescription(book.getDescription());
		bookCreateDto.setPublicationDate(book.getPublicationDate());
		
		
		
		return bookCreateDto;
		
	}
	public static void updateDtoToBook(BookCreateDto bookCreateDto, AuthorService authorService, 
			GenreService genreService, Book book){
		
		book.setId(bookCreateDto.getId());
		book.setTitle(bookCreateDto.getTitle());
		book.setDescription(bookCreateDto.getDescription());
		book.setPublicationDate(bookCreateDto.getPublicationDate());
		book.setBookAuthor(authorService.getAuthorById(bookCreateDto.getAuthorId()));
		book.setGenre(genreService.getGenreById(bookCreateDto.getGenreId()));

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

		bookDto.setId(book.getId());
		
		bookDto.setAvailableCopys(book.getBookCopies().size());
		
		return bookDto;
	}
}
