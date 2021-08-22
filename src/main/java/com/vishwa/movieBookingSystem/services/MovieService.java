package com.vishwa.movieBookingSystem.services;

import com.vishwa.movieBookingSystem.entities.Booking;
import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;

import java.util.List;

/**
 * This interface will define methods supported by
 * MovieService
 */

public interface MovieService {
    /**
     * It should be able to take a movie request and
     * save it to database
     */

    public Movie acceptMovieDetails(Movie movie);

    /**
     * I want to get the movie details based on movie id
     */

    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;

    /**
     * I want to update details existing movie
     */
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException;

    /**
     * I want to delete movie
     */
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException;

    /**
     * I want to get the Lists of all available movies
     */

    public List<Movie> getAllMoviesDetails();
}
