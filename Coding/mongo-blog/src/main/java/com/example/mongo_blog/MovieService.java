package com.example.mongo_blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    public Movie getMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}