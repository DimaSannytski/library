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

import com.ua.dto.AuthorCreateDto;
import com.ua.dto.AuthorNameFilter;
import com.ua.entity.Author;
import com.ua.mapper.AuthorMapper;
import com.ua.service.AuthorService;

@Controller
@RequestMapping("/bookauthor")
public class BookAuthorController {
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/all")
	public String showAllAuthors(Principal principal, Model model)  {
		
		List<Author> authors = authorService.findAll();
		model.addAttribute("searchModel", new AuthorNameFilter());
		model.addAttribute("authors",authors);
		
		return"/bookauthor/all";
	}
	
	@PostMapping("/search")
	public String searchAuthor(Model model,@RequestParam("search") String search,Principal principal) {

		model.addAttribute("authors",authorService.findAllByName(search));
		return "bookauthor/all";
	}
	
	@GetMapping ("/create")
	public String createAuthor(Principal principal, Model model) {

		
		model.addAttribute("createAuthor", new AuthorCreateDto());
		
		return "/bookauthor/create";
	}
	
	@PostMapping("/create")
	public String createauthor(Principal principal,@ModelAttribute("createAuthor")@Valid AuthorCreateDto request,BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/create";
		}
		Author author = AuthorMapper.dtoToAuthor(request);
		authorService.saveAuthor(author);

	
		return "redirect:/bookauthor/"+author.getId();
	}
	
	
	@GetMapping("/{authorId}")
	public String showAuthor(@PathVariable("authorId") long authorId,Principal principal,Model model) {
		Author author = authorService.getAuthorById(authorId);
		
		if (author == null) return "redirect:/bookauthor/all";
		
		model.addAttribute("authorModel", AuthorMapper.authorToDto(author));

		return"/bookauthor/author";
	}
}
