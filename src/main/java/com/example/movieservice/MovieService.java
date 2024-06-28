package com.example.movieservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = getMovieById(id);
        movie.setName(movieDetails.getName());
        movie.setCategory(movieDetails.getCategory());
        return movieRepository.save(movie);
    }

    public void setMovieAvailable(Long id) throws MovieNotFoundException {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setAvailable(true);
            movieRepository.save(movie);
        } else {
            throw new MovieNotFoundException(id);
        }
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
