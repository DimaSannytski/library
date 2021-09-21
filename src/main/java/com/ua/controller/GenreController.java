package com.ua.controller;

import com.ua.dto.GenreDto;
import com.ua.entity.Genre;
import com.ua.mapper.AuthorMapper;
import com.ua.mapper.GenreMapper;
import com.ua.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

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
    public String createGroup(Principal principal, Model model) {
        model.addAttribute("createGenre", new GenreDto());
        return "/genre/create";
    }


    @PostMapping("/create")
    public String createGroupNew(Principal principal, @ModelAttribute("createGenre")@Valid GenreDto request, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/create";
        }
        Genre genre = GenreMapper.dtoToGenre(request);
        genreService.saveGenre(genre);
        return "redirect:/genre/"+genre.getId();
    }

    @GetMapping("/{genreId}")
    public String showOneGroup(@PathVariable("genreId") long genreId,Principal principal,Model model) {
        Genre genre = genreService.getGenreById(genreId);
        if (genre == null) return "redirect:/genre/all";
        model.addAttribute("genreModel", GenreMapper.genreToDto(genre));
        return"/genre/genre";
    }
}
