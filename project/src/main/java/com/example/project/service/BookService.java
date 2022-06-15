package com.example.project.service;

import com.example.project.model.binding.BookBindingModel;
import com.example.project.model.view.BooksViewModel;

import java.util.List;

public interface BookService {

    int count();
    void saveBook(BookBindingModel book);

    List<BooksViewModel> getAll();
}
