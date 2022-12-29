package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        return movieRepository.addMovieInDb(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirectorInDb(director);
    }

    public Movie getMovieByName(String searchName) {
        return movieRepository.getMovieByNameFromDb(searchName);
    }

    public Director getDirectorByName(String searchName) {
        return movieRepository.getDirectorByNameFromDb(searchName);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMoviesFromDb();
    }

    public String deleteDirectorByName(String directorName) {
        return movieRepository.deleteDirectorByNameFromDb(directorName);
    }

    public String deleteAllDirectors() {
        return movieRepository.deleteAllDirectorsFromDb();
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirectorName(directorName);
    }

}
