package com.vishwa.movieBookingSystem.services.impl;


import com.vishwa.movieBookingSystem.dao.*;
import com.vishwa.movieBookingSystem.entities.City;
import com.vishwa.movieBookingSystem.entities.Movie;
import com.vishwa.movieBookingSystem.entities.Status;
import com.vishwa.movieBookingSystem.entities.UserType;
import com.vishwa.movieBookingSystem.services.CityService;
import com.vishwa.movieBookingSystem.services.InitService;
import com.vishwa.movieBookingSystem.services.MovieService;
import com.vishwa.movieBookingSystem.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    //private CityDao cityDao; //inClass
    private CityService cityService;

    @Autowired
    private UserTypeDao userTypeDao;

    @Autowired
    private StatusService statusService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TheatreDao theatreDao;

    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private BookingDao bookingDao;

    /**
     * Cooking data
     * <p>
     * Define and initialize together
     * <p>
     * int i ; -- defining a variable
     * i=5 ; -- assigning a value
     * <p>
     * <p>
     * int i = 5 ; -- define and assign at the same time
     */
    List<Status> statuses = Arrays.asList(new Status("UPCOMING"),
            new Status("RELEASED"), new Status("BLOCKED"));


    @Override
    public void init() {
        /**
         * Write the logic to store date inside the database in different tables
         */

        /**
         * Add cities
         */
        //List<City> cities = new ArrayList<>(); //inClass
        //cities.add(new City("Patna"));//inClass
        //cities.add(new City("Bengaluru"));//inClass
        //cities.add(new City("Kolkata"));//inClass
        //cities.add(new City("Mumbai"));//inClass
        //cities.forEach(city -> cityDao.save(city));//inClass

        createCities();


        /**
         * Add User Types
         */

        createUserTypes();

        /**
         * Add Statuses
         */
        createStatuses();

        /**
         * Add Movies
         */

        createMovies();

        /**
         * Add Users
         *
         */


        /**
         * Add theatres
         */

        /**
         * MovieTheatres
         */

        /**
         * Booking
         */

    }

    private void createMovies() { 
        Movie movie1 = new Movie();
        movie1.setMovieName("Movie1_Name");
        movie1.setTrailerUrl("Movie1_T_URL");
        movie1.setStatus(statuses.get(1));
        movie1.setMovieDescription("Movie1 description");
        movie1.setDuration(120);
        movie1.setTrailerUrl("Movie1_T_URL");
        movie1.setReleaseDate(LocalDateTime.of(2018, 4, 27, 5, 30));
        movie1.setCoverPhotoUrl("Movie1_C_URL");

        Movie movie2  = new Movie();
        movie2.setMovieName("Movie2_Name");
        movie2.setTrailerUrl("Movie2_T_URL");
        movie2.setStatus(statuses.get(1));
        movie2.setMovieDescription("Movie2 description");
        movie2.setDuration(120);
        movie2.setTrailerUrl("Movie2_T_URL");
        movie2.setReleaseDate(LocalDateTime.of(2018, 5, 27, 5, 30));
        movie2.setCoverPhotoUrl("Movie2_C_URL");

        movieService.acceptMovieDetails(movie1);

        movieService.acceptMovieDetails(movie2);




    }

    private void createStatuses() {

        statuses.forEach(status -> {
            statusService.acceptStatusDetails(status);
        });
    }

    private void createUserTypes() {
        List<UserType> userTypes = new ArrayList<>();
        userTypes.add(new UserType("Customer"));
        userTypes.add(new UserType("Admin"));

        userTypes.forEach(userType -> {
            userTypeDao.save(userType);
        });
    }

    private void createCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Patna"));
        cities.add(new City("Bangalore"));
        cities.add(new City("Kolkata"));
        cities.add(new City("Mumbai"));

        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}