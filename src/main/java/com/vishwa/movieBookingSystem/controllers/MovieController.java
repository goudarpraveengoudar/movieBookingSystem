package com.vishwa.movieBookingSystem.controllers;


import com.vishwa.movieBookingSystem.dtos.MovieDTO;
import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.vishwa.movieBookingSystem.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * End Point
 * Root Path -> mbs/v1
 * 127.0.0.1:8084/mbs/v1/
 */


@RestController
/**
 * 1. @Component
 * 2. Give hint to Spring, that whenever a REST call
 * comes, make sure this class is informed
 */
@RequestMapping("/movies")
/**
 * 127.0.0.1:8084/mbs/v1/movies
 */

public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService movieService;
    /**
     * We need to define the Bean of Model Mapper
     */

    /**
     * How to create the bean of a class, which I have not created
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * GET 127.0.0.1:8084/mbs/v1/movies/greeting
     * Hello People
     */

    @GetMapping("/greeting")
    public ResponseEntity helloWorld() {
        LOGGER.info("Inside the hello world Method");
        return new ResponseEntity("Hello people", HttpStatus.OK);
    }

    /**
     * Get all the movies
     * Get 127.0.0.1:8084/mbs/v1/movies
     */
    @GetMapping
    public ResponseEntity getAllMovies() {
        /**
         * First get all the movies
         */
        List<Movie> movies = movieService.getAllMoviesDetails();
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for (Movie movie : movies) {
            movieDTOS.add(covertToMovieDTO(movie));
        }

        /**
         * Wrap inside the ResponseEntity
         */
        return new ResponseEntity(movieDTOS, HttpStatus.OK);
    }

    /**
     * Get the movie details based on the id
     * GET 127.0.0.1:8084:mbs/v1/movies/{movieId}
     */
    @GetMapping("/{movieId}")
    public ResponseEntity getMovieBasedOnID(
            @PathVariable(name = "movieId") int movieId)  throws MovieDetailsNotFoundException {

Movie movie = movieService.getMovieDetails(movieId);
/**
     * Convert the Movie object to MovieDTO object
     */

        MovieDTO movieDTO = covertToMovieDTO(movie);

    /**
 * I should not use, Movie class to return the response to the client
 */

        return new ResponseEntity(movieDTO, HttpStatus.OK);

}


    /**
     * I want to create a new movie
     * POST 127.0.0.1:8084/mbs/v1/movies
     * <p>
     * this method expects some request body
     */

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO) {
        //Logic to create the movie
        //I need to create the new movie
        //I need to create Movie object from MovieDTo object
        Movie movie = modelMapper.map(movieDTO, Movie.class);

        // movieService.acceptMovieDetails(movieDTO);
        Movie savedMovie = movieService.acceptMovieDetails(movie);
        //Again I need to convert it back to MovieDTO to send back to client
        MovieDTO responseBody = modelMapper.map(savedMovie, MovieDTO.class);
        return new ResponseEntity(responseBody, HttpStatus.CREATED);
    }

    /**
     * I would like to update an already existing movie
     * PUT 127.0.0.1:8084/mbs/v1/movies/{movieId}
     * JSON Body has to be passed
     */

    @PutMapping(value = "/{moviesId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@RequestBody MovieDTO movieDTO,
                                             @PathVariable(name = "movieId") int movieId)
            throws MovieDetailsNotFoundException {

        /**
         * First check if  the movie is present in the system or not
         *If the Movie is not present, throws the exception
         */
        Movie storeMovie = movieService.getMovieDetails(movieId);
        Movie movieToBeUpdated = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieService.updateMovieDetails(movieId, movieToBeUpdated);

        MovieDTO savedResponse = modelMapper.map(savedMovie, MovieDTO.class);
        return new ResponseEntity(savedResponse, HttpStatus.ACCEPTED);
    }


    private MovieDTO covertToMovieDTO(Movie movie) {
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
        return movieDTO;
    }

    /**
     * DELETE 127.0.01:8084/mbs/v1/movies/{movie_id}
     */
    @DeleteMapping(value = "/{movie_id}")
    public ResponseEntity deleteMovie(@PathVariable(name = "movie_id") int id) throws MovieDetailsNotFoundException {
        movieService.deleteMovie(id);

        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }
}




