package com.example.project.init;

import com.example.project.service.GenreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initDB implements CommandLineRunner {

    private final GenreService genreService;

    public initDB(GenreService genreService) {
        this.genreService = genreService;
    }


    @Override
    public void run(String... args) throws Exception {
        if(genreService.count()==0) {
            genreService.init();
        }
    }
}
