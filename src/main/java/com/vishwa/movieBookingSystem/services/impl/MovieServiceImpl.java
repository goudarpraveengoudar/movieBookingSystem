package com.vishwa.movieBookingSystem.services.impl;

import com.vishwa.movieBookingSystem.dao.MovieDao;
import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.vishwa.movieBookingSystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    /**
     * To talk the database, I need the help of MovieDao
     */

    @Autowired
    public MovieDao movieDao;

    /**
     * With the help of MovieDeo save onto db
     */

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException {
        /**
         * Fetch the movie details based on the id
         */
        return movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found for id: " + id));

    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException {
        Movie savedMovie = getMovieDetails(id);

        /**
         * Update the movie
         */

       // Movie savedMovie = movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found for id: " + id));

        /**
         * Read the attributes from the movie object and update it in savedMovie
         */

        if (isNotNullOrZero(movie.getMovieName())) {
            savedMovie.setMovieName(movie.getMovieName());
        }
        if (isNotNullOrZero(movie.getMovieDescription())) {
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }
        if (isNotNullOrZero(movie.getReleaseDate())) {
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }
        if (isNotNullOrZero(movie.getDuration())) {
            savedMovie.setDuration(movie.getDuration());
        }
        if (isNotNullOrZero(movie.getCoverPhotoUrl())) {
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }
        if (isNotNullOrZero(movie.getTrailerUrl())) {
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }
        if (isNotNullOrZero(movie.getStatus())) {
            savedMovie.setStatus(movie.getStatus());
        }

        return movieDao.save(savedMovie);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    private boolean isNotNullOrZero(int val) {
        return val != 0;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
        Movie savedMovie = getMovieDetails(id);
        movieDao.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMoviesDetails() {
        return movieDao.findAll();
    }
}
