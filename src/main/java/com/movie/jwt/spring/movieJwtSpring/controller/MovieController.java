package com.movie.jwt.spring.movieJwtSpring.controller;


import com.movie.jwt.spring.movieJwtSpring.model.Movie;
import com.movie.jwt.spring.movieJwtSpring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
