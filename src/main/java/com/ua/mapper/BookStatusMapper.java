package com.ua.mapper;

import com.ua.dto.BookStatusDto;
import com.ua.entity.BookStatus;

public interface BookStatusMapper {

    public static BookStatus dtoToBookStatus(BookStatusDto bookStatusDto) {
        BookStatus bookStatus = new BookStatus();
        bookStatus.setTitle(bookStatusDto.getTitle());
        return bookStatus;
    }

    public static BookStatusDto bookStatusToDto(BookStatus bookStatus) {
        BookStatusDto bookStatusDto = new BookStatusDto();
        bookStatusDto.setTitle(bookStatus.getTitle());
        return bookStatusDto;
    }
}