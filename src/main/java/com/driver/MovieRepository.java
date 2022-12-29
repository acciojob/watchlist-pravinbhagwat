package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<Director, List<Movie>> movieDirectorDb = new HashMap<>();
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
        Director director = directorDb.get(directorName);
        List<Movie> movieList = movieDirectorDb.get(director);
        for (Movie movie : movieList) {
            movieDb.remove(movie.getName());
        }
        directorDb.remove(directorName);
        movieDirectorDb.remove(director);

        return "Successfully deleted movies related to given director";
    }

    public String deleteAllDirectorsFromDb() {
        List<Director> directors= new ArrayList<>();
        for (Map.Entry<Director, List<Movie>> set :
                movieDirectorDb.entrySet()) {
            List<Movie> movieList = set.getValue();
            for (Movie movie : movieList) {
                movieDb.remove(movie.getName());
            }

            directors.add(set.getKey());
            directorDb.remove(set.getKey().getName());
        }
        for (Director director : directors
        ) {
            directorDb.remove(director.getName());
        }
        return "Successfully deleted all directors and movies";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        Movie movie = getMovieByNameFromDb(movieName);
        if (movieDirectorDb.containsKey(getDirectorByNameFromDb(directorName))) {

            List<Movie> movieList = movieDirectorDb.get(getDirectorByNameFromDb(directorName));
            movieList.add(movie);
            movieDirectorDb.put(getDirectorByNameFromDb(directorName), movieList);
        } else {
            List<Movie> movieList = new ArrayList<>();
            movieList.add(movie);
            movieDirectorDb.put(getDirectorByNameFromDb(directorName), movieList);
        }
        return "Successfully created movie director pair";
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        Director director = directorDb.get(directorName);
        List<Movie> movieList = movieDirectorDb.get(director);
        List<String> movieNameList = new ArrayList<>();
        for (Movie movie : movieList) {
            movieNameList.add(movie.getName());
        }
        return movieNameList;
    }
}
