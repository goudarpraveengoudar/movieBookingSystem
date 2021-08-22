package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.Movie;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieDao extends JpaRepository<Movie, Integer> {

    /**
     * I also want ot support the search based on the movie name.
     */

    public List<Movie> findByMovieName(String movieName);

    /**
     * I want to query based on multiple columns
     * query based on name and duration.
     */

    public List<Movie> findByMovieNameAndDuration(String name, int duration);

    public List<Movie> findByReleaseDateBetween(LocalDateTime start, LocalDateTime end);

    /**
     * Find the movie with duration greater than given hour
     */
    public List<Movie> findByDurationGreaterThanEqual(int duration);

    public List<Movie> findByReleaseDateAfter(LocalDateTime releaseDate);

    public List<Movie> findByMovieNameContaining(String movieName);

    public List<Movie> findByMovieNameIgnoreCase(String movieName);
}