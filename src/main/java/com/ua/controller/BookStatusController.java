package com.ua.controller;

import com.ua.dto.BookStatusDto;
import com.ua.entity.BookStatus;
import com.ua.mapper.BookStatusMapper;
import com.ua.service.BookStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/bookstatus")
public class BookStatusController {

    @Autowired
    BookStatusService bookStatusService;

    @GetMapping("/all")
    public String showAllBookStatus(Principal principal, Model model)  {
        List<BookStatus> bookStatus = bookStatusService.findAll();
        model.addAttribute("bookStatus",bookStatus);
        return"/bookstatus/all";
    }

    @GetMapping ("/create")
    public String createBookStatus(Principal principal, Model model) {
        model.addAttribute("createBookStatus", new BookStatusDto());
        return "/bookstatus/create";
    }

    @PostMapping("/create")
    public String createBookStatus(Principal principal, @ModelAttribute("createBookStatus") @Valid BookStatusDto request,
                                   BindingResult result) {

        if(result.hasErrors()) {
            return "/bookstatus/create";
        }
        BookStatus bookStatus = BookStatusMapper.dtoToBookStatus(request);
        bookStatusService.saveBookStatus(bookStatus);
        return "redirect:/bookstatus/all";
    }
}