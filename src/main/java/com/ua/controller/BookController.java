package com.ua.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ua.dto.BookCreateDto;
import com.ua.dto.SearchByOneFieldDto;
import com.ua.entity.Book;
import com.ua.mapper.BookMapper;
import com.ua.service.AuthorService;
import com.ua.service.BookCopyService;
import com.ua.service.BookService;
import com.ua.service.GenreService;


@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired 
	GenreService genreService;
	@Autowired 
	AuthorService authorService;
	@Autowired
	BookCopyService bookCopyService;
	
	@GetMapping("/all")
	public String showAllBooks(Principal principal, Model model) {
		
		List<Book> books = bookService.findAll();
		model.addAttribute("searchModel", new SearchByOneFieldDto());
		model.addAttribute("bookModel",books);
		
		return"/book/all";
	}
	
	@GetMapping ("/create")
	public String createBook(Principal principal, Model model) {

		
		model.addAttribute("createBook",new BookCreateDto());
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		
		return "/book/create";
	}
	
	@PostMapping("/create")
	public String createBook(Principal principal,@ModelAttribute("createBook")@Valid BookCreateDto request,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors().toString());
			return "/book/create";
		}
		Book book = BookMapper.createDtoToBook(request, authorService, genreService);
		bookService.saveBook(book);
		bookService.createBookCopys(book, request.getCopyCount());
	
		return "redirect:/book/"+book.getId();
	}
	
	
	@GetMapping("/{bookId}")
	public String showBook(@PathVariable("bookId") long bookId,Principal principal,Model model) {
		Book book = bookService.getBookById(bookId);
		if (book == null) return "redirect:/book/all";
		
		model.addAttribute("bookModel", BookMapper.bookToDto(book));
		
		
		return"book/book";
	}
	
	@GetMapping("/edit/{bookId}")
	public String editBook(@PathVariable("bookId") long bookId,Principal principal,Model model) {
		Book book = bookService.getBookById(bookId);
		if (book == null) return "redirect:/book/all";
		
		//model.addAttribute("bookModel", BookMapper.bookToDto(book));
		
		
		return"book/book";
	}
	
	@PostMapping("/search")
	public String searchBookByTitle(Model model,@RequestParam("search") String search,Principal principal) {

		model.addAttribute("bookModel",bookService.findByTitle(search));
		return "book/all";
	}
}
