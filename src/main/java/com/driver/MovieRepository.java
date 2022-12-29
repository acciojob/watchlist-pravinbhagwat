package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    public String addMovieInDb(Movie movie) {
        String movieName = movie.getName();
        movieDb.put(movieName, movie);
        return "Successfully added the movie";
    }

    public String addDirectorInDb(Director director) {
        String directorName = director.getName();
        directorDb.put(directorName, director);
        return "Director Added Successfully";
    }

    public Movie getMovieByNameFromDb(String searchName) {
        return movieDb.getOrDefault(searchName, null);
    }

    public Director getDirectorByNameFromDb(String searchName) {
        return directorDb.getOrDefault(searchName, null);
    }

    public List<String> findAllMoviesFromDb() {
        List<String> allMovieList = new ArrayList<>();
        for (Map.Entry<String, Movie> movie : movieDb.entrySet()) {
            allMovieList.add(movie.getKey());
        }
        return allMovieList;
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
