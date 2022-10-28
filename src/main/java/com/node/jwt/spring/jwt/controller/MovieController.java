package com.node.jwt.spring.jwt.controller;


import com.node.jwt.spring.jwt.model.Movie;
import com.node.jwt.spring.jwt.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService service;

    @Autowired
    public MovieController(MovieService service){
        this.service = service;
    }

    @PostMapping("/add-movie")
    public String saveMovie(@RequestBody Movie movie){
        return service.saveMovie(movie);
    }

    @GetMapping("/get-movies")
    public List<Movie> getMovies(){
        return service.getMovies();
    }
}
