package com.example.project.web;

import com.example.project.model.binding.BookBindingModel;
import com.example.project.service.BookService;
import com.example.project.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TableController {

    private final GenreService genreService;
    private final BookService bookService;
    public TableController(GenreService genreService, BookService bookService) {
        this.genreService = genreService;
        this.bookService = bookService;
    }

    @ModelAttribute
    public BookBindingModel bookBindingModel() {
        return new BookBindingModel();
    }

    @GetMapping("/")
    public String index(Model model) {
        if(!model.containsAttribute("isFull"))
            model.addAttribute("isFull",false);
        if(!model.containsAttribute("window"))
            model.addAttribute("window",false);

        model.addAttribute("books",bookService.getAll());
        return "index";
    }

    @PostMapping("/")
    public String redirectIndex(@Valid BookBindingModel bookBindingModel, RedirectAttributes redirectAttributes, Model model) {

        if(bookService.count()>100) {
            redirectAttributes
                    .addFlashAttribute("isFull",true);
        } else {
            redirectAttributes.addFlashAttribute("window",true);
            bookService.saveBook(bookBindingModel);
        }

        return "redirect:/";
    }
}
