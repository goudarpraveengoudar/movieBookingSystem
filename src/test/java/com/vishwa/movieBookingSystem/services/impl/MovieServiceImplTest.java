package com.vishwa.movieBookingSystem.services.impl;

import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.entities.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * This class will be used to write the test cases
 *of the MovieServiceImpl class
 */
@SpringBootTest
public class MovieServiceImplTest {

    /**
     * Tell spring to inject the dependency
     */
    @Autowired
    private MovieServiceImpl movieService;
    @Autowired
    private StatusServiceImpl statusService;

    Movie movie;

    @BeforeEach
    public void beforeTest(){
        movie = new Movie();
        movie.setMovieName("Name1");
        movie.setMovieDescription("Desc1");
        movie.setCoverPhotoUrl("CP_URL");
        movie.setReleaseDate(LocalDateTime.of(2018,10,5,6,30));
        movie.setDuration(120);
        Status status = new Status();
        status.setStatusName("RELEASED");
        statusService.acceptStatusDetails(status);
        movie.setStatus(status);
        movie.setTrailerUrl("T_url");
    }
/**
 * Test acceptMovieDetails
 */
@Test
public void testAcceptMovieDetails(){
    System.out.println("Movie Service object");

    /**
     * Check if this method is able to save a movie detail or not
     */

    Movie savedMovie = movieService.acceptMovieDetails(movie);

    Assertions.assertNotNull(savedMovie);
    Assertions.assertNotNull(savedMovie.getMovieId());

}

/**
 * Test getMovieDetails
 */

/**
 * Test updateMovieDetails
 */






/**
 * Test deleteMovie
 */

}
