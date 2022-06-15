package com.example.project.service;


import com.example.project.model.entity.Genre;
import com.example.project.model.entity.Genres;

public interface GenreService {

    void init();

    public int count();

    Genre findGenre(Genres genre);
}
