package com.example.project.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Books extends BaseEntity {

    private String name;
    private String author;
    private Genre genre;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @ManyToOne
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
