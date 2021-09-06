package com.vishwa.movieBookingSystem.services.impl;

import com.vishwa.movieBookingSystem.dao.MovieDao;
import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.entities.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MovieServiceImplUnitTest {

    /**
     * MovieServiceIMPL, it depends on MovieDao
     *
     * 1 We need to create a dummy of  MovieDao
     * 2 and replace original MovieDao Present in MovieServeImpl
     */

    /**
     * This is the dummy or mocked MovieDao
     */
    @Mock
    private MovieDao movieDao;
    /**
     * This create the movieServiceImpl object with mocked movieDao
     */
    @InjectMocks
    private MovieServiceImpl movieService;

    Movie movie;

    @BeforeEach
    public void beforeTest(){
        movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieName("Name1");
        movie.setMovieDescription("Desc1");
        movie.setCoverPhotoUrl("CP_URL");
        movie.setReleaseDate(LocalDateTime.of(2018,10,5,6,30));
        movie.setDuration(120);
        Status status = new Status();
        status.setStatusName("RELEASED");
       // statusService.acceptStatusDetails(status);
        movie.setStatus(status);
        movie.setTrailerUrl("T_url");


        /**
         * Adding the functionality on MovieDao
         * It says to MovieDao, when save method is called, just return the object back
         * This doesn't involve actually calling of the database
         */


        Mockito.when(movieDao.save(movie)).thenReturn(movie);
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
}
