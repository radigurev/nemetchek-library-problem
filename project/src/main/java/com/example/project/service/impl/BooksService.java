package com.example.project.service.impl;

import com.example.project.model.binding.BookBindingModel;
import com.example.project.model.entity.Books;
import com.example.project.model.view.BooksViewModel;
import com.example.project.repository.BookRepository;
import com.example.project.service.BookService;
import com.example.project.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final GenreService genreService;

    public BooksService(BookRepository bookRepository, ModelMapper modelMapper, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.genreService = genreService;
    }



    @Override
    public int count() {
        return (int) bookRepository.count();
    }

    @Override
    public void saveBook(BookBindingModel book) {
        Books newBook=modelMapper.map(book,Books.class);
        newBook.setGenre(genreService.findGenre(book.getGenre()));
        bookRepository.saveAndFlush(newBook);
    }

    @Override
    public List<BooksViewModel> getAll() {
        return bookRepository.findAll().stream().map(b -> modelMapper.map(b,BooksViewModel.class)).collect(Collectors.toList());
    }
}
