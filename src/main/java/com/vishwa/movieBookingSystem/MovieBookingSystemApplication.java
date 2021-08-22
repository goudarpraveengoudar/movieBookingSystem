package com.vishwa.movieBookingSystem;

import com.vishwa.movieBookingSystem.dao.MovieDao;
import com.vishwa.movieBookingSystem.dao.CityDao;
import com.vishwa.movieBookingSystem.dao.StatusDao;
import com.vishwa.movieBookingSystem.dao.TheatreDao;
import com.vishwa.movieBookingSystem.entities.City;
import com.vishwa.movieBookingSystem.entities.Movie;
import java.time.LocalDateTime;
import java.util.List;

import com.vishwa.movieBookingSystem.entities.Status;
import com.vishwa.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.vishwa.movieBookingSystem.services.InitService;
import com.vishwa.movieBookingSystem.services.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MovieBookingSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		System.out.println("Hello Spring Boot !!! ");
		MovieService movieService = ctx.getBean(MovieService.class);

		/**StatusDuo statusDuo =ctx.getBean(StatusDao.class);
		 Status status =new Status();
		 status.setStatusName("RELEASED");
		 /* *
		 * Save the status

		// statusDao.save(status);

		 **/

		Movie movie = new Movie();
		movie.setMovieDescription("Good Movie");
		movie.setMovieName("Story of Gold in Olympics");
		movie.setTrailerUrl("trailer_url");
		movie.setDuration(120);
		movie.setReleaseDate(LocalDateTime.of(2020,1,2,4,20));
		movie.setCoverPhotoUrl("cover_url");
		// movie.setStatus(status);

		// movieService.acceptedMovieDetails(movie);
		//Movie storedM = movieService.acceptMovieDetails(movie);
		//try {
		//	movieService.getMovieDetails(storedM.getMovieId());
		//} catch (MovieDetailsNotFoundException e) {
		//	e.printStackTrace();
		// }
		//try {
		//	movieService.getMovieDetails(123);
		// } catch (MovieDetailsNotFoundException e) {
		//	e.printStackTrace();
		// }


	}

	/**
	 * This is way to execute something in the very beginning when application
	 * is starting up
	 *
	 * @param initService
	 * @return
	 */
	@Bean
	CommandLineRunner init(InitService initService) {
		return args -> {
			System.out.println("This will be executed as soon as the application is started");
			initService.init();
		};
	}
}


	// {
	// MovieDao movieDao = ctx.getBean(MovieDao.class);
		/**
		 *  I should be able to save the entity
		 **/
		/** System.out.println("======CREATING MOVIE OBJECT======");
		Movie movie = new Movie();

		//movie.setMovieName("Dhoom Again");
		//movie.setMovieDescription("Another AB movie ");
		//movie.setReleaseDate(LocalDateTime.of(2018, 4, 27, 5, 30));
		//movie.setDuration(150);
		//movie.setCoverPhotoUrl("cover-photo-url");
		//movie.setTrailerUrl("trailer-url");

		//Movie movie1 = new Movie();

		//movie1.setMovieName("KESARI");
		//movie1.setMovieDescription("Nice movie ");
		//movie1.setReleaseDate(LocalDateTime.of(2019, 8, 17, 6, 30));
		//movie1.setDuration(150);
		//movie1.setCoverPhotoUrl("cover-photo-url");
		//movie1.setTrailerUrl("trailer-url");

		// System.out.println("Before Saving: " + movie);

		System.out.println("===== AFTER SAVING THE MOVIE =====");

		//Movie savedMovie = movieDao.save(movie);
		//Movie savedMovie1 = movieDao.save(movie1);

		//System.out.println("After saving: " + savedMovie);
		//System.out.println("After saving1: " + savedMovie1);

		/**
		 * I should be able to find the movie I am interested
		* */
		//Movie searchedMovie = movieDao.findById(2).get();
		//System.out.println("Searched Movie:" + searchedMovie);

		//movie.setMovieDescription("Updated Description");
		//movieDao.save(movie);
		/**
		 * I want to delete the movie
		 **/
		//movieDao.delete(searchedMovie);

		//Movie movie2 = new Movie();

		//movie2.setMovieName("Mission Impossible");
		//movie2.setMovieId(4);
		//movie2.setMovieDescription("Nice movie ");
		//movie2.setReleaseDate(LocalDateTime.of(2019, 8, 17, 6, 30));
		//movie2.setDuration(150);
		//movie2.setCoverPhotoUrl("cover-photo-url");
		//movie2.setTrailerUrl("trailer-url");

		//movieDao.save(movie2);

		// Movie result = movieDao.findByMovieName("Mission Impossible");
		 //List<Movie> result = (List<Movie>) movieDao.findByMovieName("Mission Impossible");
		//System.out.println("result:"+ result);


		// Movie retrievedMovie = movieDao.findById(savedMovie.getMovieId()).orElse(null);
		// System.out.println("After retrieving: " + retrievedMovie);

		// movie.setDuration(160);
		// Movie updatedMovie = movieDao.save(movie);
		// System.out.println("After updating: " + updatedMovie);

		// movieDao.delete(updatedMovie);
		// System.out.println("After deleting: " + movieDao.findById(updatedMovie.getMovieId()));
