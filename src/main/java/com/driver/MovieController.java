package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie) {
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director) {
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_movie_by_name")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String searchName) {
        Movie movie = movieService.getMovieByName(searchName);
        if(movie == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/get_director_by_name")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("name") String searchName) {
        Director director = movieService.getDirectorByName(searchName);
        if(director == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @GetMapping("/get_all_movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> allMoviesList = movieService.findAllMovies();
        if(allMoviesList == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(allMoviesList, HttpStatus.OK);
    }

    @DeleteMapping("/delete_director_by_name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName) {
        String response = movieService.deleteDirectorByName(directorName);
        if(response == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete_all_directors")
    public ResponseEntity<String> deleteAllDirectors() {
        String response = movieService.deleteAllDirectors();
        if(response == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/add_movie_director_pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        String response = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/add_movies_by_director_name/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("directorName") String directorName) {
        List<String> moviesList = movieService.getMoviesByDirectorName(directorName);
        if(moviesList == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(moviesList, HttpStatus.OK);
    }

}

