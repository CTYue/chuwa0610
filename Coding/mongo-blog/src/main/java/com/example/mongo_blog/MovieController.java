package com.example.mongo_blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/imdb/{imdbId}")
    public Movie getMovieByImdbId(@PathVariable String imdbId) {
        return movieService.getMovieByImdbId(imdbId);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
    }
}