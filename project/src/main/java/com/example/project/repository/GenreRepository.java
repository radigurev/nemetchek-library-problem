package com.example.project.repository;

import com.example.project.model.entity.Genre;
import com.example.project.model.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,String> {

    Optional<Genre> findByGenre(Genres genre);
}
