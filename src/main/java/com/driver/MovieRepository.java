package com.driver;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    public String addMovieInDb(Movie movie) {
    }

    public String addDirectorInDb(Director director) {
    }

    public Movie getMovieByNameFromDb(String searchName) {
    }

    public Director getDirectorByNameFromDb(String searchName) {
    }

    public List<String> findAllMoviesFromDb() {
    }

    public String deleteDirectorByNameFromDb(String directorName) {
    }

    public String deleteAllDirectorsFromDb() {
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
    }

    public List<String> getMoviesByDirectorName(String directorName) {
    }
}
