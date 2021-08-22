package com.vishwa.movieBookingSystem.dao;

import com.vishwa.movieBookingSystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingDao extends JpaRepository<Booking, Integer> {
/**
 * I want to support the search based on movie name
 */
// public List<Movie> findByMovieName(String movieName);

/**
 * I want to query based on multiple  columns
 * query based on name and duration
 */
// public List<Movie> findByMovieNameAndDuration (String name, int duration);

/**
 * Find the movie with duration grater than 1 hour
 */


// public List<Movie> findByDurationGraterThanEqual(int duration);


}

