package com.ua.mapper;

import com.ua.dto.AuthorCreateDto;
import com.ua.dto.AuthorDto;
import com.ua.entity.Author;

public interface AuthorMapper {

	public static Author dtoToAuthor(AuthorCreateDto authorCreateDto) {
		Author author = new Author();
		author.setFirstName(authorCreateDto.getFirstName());
		author.setLastName(authorCreateDto.getLastName());
		return author;
	}
	
	public static AuthorDto authorToDto(Author author) {
		AuthorDto authorDto = new AuthorDto();
		authorDto.setFirstName(author.getFirstName());
		authorDto.setLastName(author.getLastName());
		return authorDto;
	}
}

