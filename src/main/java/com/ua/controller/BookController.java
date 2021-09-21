package com.ua.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ua.dto.BookCreateDto;
import com.ua.dto.BookTitleFilter;
import com.ua.entity.Book;
import com.ua.mapper.BookMapper;
import com.ua.service.BookService;
import com.ua.service.GenreService;


@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired 
	GenreService genreService;
	
	@GetMapping("/all")
	public String showAllUsers(Principal principal, Model model) {
		
		List<Book> books = bookService.findAll();
		model.addAttribute("searchModel", new BookTitleFilter());
		model.addAttribute("bookModel",books);
		
		return"/book/all";
	}
	
	@GetMapping ("/create")
	public String createGroup(Principal principal, Model model) {

		
		model.addAttribute("createBook",new BookCreateDto());
		
		return "/book/create";
	}
	
	@PostMapping("/create")
	public String createGroupNew(Principal principal,@ModelAttribute("createBook")@Valid BookCreateDto request,BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/create";
		}
		Book book = BookMapper.createDtoToBook(request);
		bookService.saveBook(book);

	
		return "redirect:/book/"+book.getId();
	}
	
	
	@GetMapping("/{bookId}")
	public String showOneGroup(@PathVariable("bookId") long bookId,Principal principal,Model model) {
		Book book = bookService.getBookById(bookId);
		if (book == null) return "redirect:/book/all";
		
		model.addAttribute("bookModel", BookMapper.bookToDto(book));

		return"book/book";
	}


}
