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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ua.dto.GenreDto;
import com.ua.entity.Genre;
import com.ua.mapper.GenreMapper;
import com.ua.service.GenreService;

@Controller
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/all")
    public String showAllGenres(Principal principal, Model model) {

        List<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);
        return "/genre/all";
    }

    @GetMapping ("/create")
    public String createGenre(Principal principal, Model model) {
        model.addAttribute("createGenre", new GenreDto());
        return "/genre/create";
    }


    @PostMapping("/create")
    public String createGenre(Principal principal, @ModelAttribute("createGenre")@Valid GenreDto request, BindingResult result) {
        if(result.hasErrors()) {
            return "/genre/create";
        }
        Genre genre = GenreMapper.dtoToGenre(request);
        genreService.saveGenre(genre);
        return "redirect:/genre/all";
    }

//    @GetMapping("/{genreId}")
//    public String showOneGenre(@PathVariable("genreId") long genreId,Principal principal,Model model) {
//        Genre genre = genreService.getGenreById(genreId);
//        if (genre == null) return "redirect:/genre/all";
//        model.addAttribute("genreModel", GenreMapper.genreToDto(genre));
//        return"/genre/genre";
//    }
}