package com.example.project.service.impl;

import com.example.project.model.entity.Genre;
import com.example.project.model.entity.Genres;
import com.example.project.repository.GenreRepository;
import com.example.project.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GenresService implements GenreService {

    private final GenreRepository genreRepository;

    public GenresService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void init() {
        Arrays.stream(Genres.values()).forEach(g -> {
            Genre genre=new Genre();
            genre.setGenre(g);
            genreRepository.saveAndFlush(genre);
        });
    }

    @Override
    public int count() {
        return (int) genreRepository.count();
    }

    @Override
    public Genre findGenre(Genres genre) {
        return genreRepository.findByGenre(genre).orElse(null);
    }


}
