package com.ua.mapper;

import com.ua.dto.GenreDto;
import com.ua.entity.Genre;

public interface GenreMapper {

    public static Genre dtoToGenre(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setTitle(genreDto.getTitle());
        return genre;
    }

    public static GenreDto genreToDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.setTitle(genre.getTitle());
        return genreDto;
    }
}
