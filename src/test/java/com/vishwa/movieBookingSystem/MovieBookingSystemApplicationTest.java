package com.vishwa.movieBookingSystem;

import com.vishwa.movieBookingSystem.dao.MovieDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieBookingSystemApplicationTest {


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

	@Test
	void contextLoads() {
	}

}
