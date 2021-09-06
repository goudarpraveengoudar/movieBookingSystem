package com.vishwa.movieBookingSystem.services.impl;

import com.vishwa.movieBookingSystem.dao.CityDao;
import com.vishwa.movieBookingSystem.entities.City;
import com.vishwa.movieBookingSystem.exceptions.CityDetailsNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CityServiceImplTest {
    /**
     * CityServiceImpl -> CityDao
     * Unit test :
     * 1. Create of mock of CityDao
     * 2. Create CityServiceImpl using mocked CityDao
     * 3. Provide the functionality to CityDao
     */

    /**
     * Create mock of CityDao
     */
    @Mock
    private CityDao cityDao;


    /**
     * Create CityServiceImpl using mocked CityDao
     */

    @InjectMocks
    private CityServiceImpl cityService;

    /**
     * Provide the functionality to CityDao
     */
    @BeforeEach
    public void addFunctionalityToMockedCityDao() {
        Mockito.when(cityDao.save(new City("Bangalore")))
                .thenReturn(new City(1, "Bangalore"));


        //Mock the function for get
        Mockito.when(cityDao.findById(2))
                .thenReturn(Optional
                        .of(new City(2, "Mumbai")));
        Mockito.when(cityDao
                .save(new City(2,"MumbaiNew"))).thenReturn(new City(2,"MumbaiNew"));
    }


    /**
     * acceptCityDetails
     */
    @Test
    public void testAcceptCityDetails() {
        /**
         * Test if CityServiceImpl is able to save City Details
         */
        City city = new City("Bangalore");
        City savedCity = cityService.acceptCityDetails(city);

        /**
         * Assertion -> expected is matching with actual or not?
         *
         */
        Assertions.assertNotNull(savedCity);
        Assertions.assertEquals(1, savedCity.getCityId());
        System.out.println(savedCity);
    }

/**
 * acceptMultipleDetails
 */

    /**
     * updateCityDetails
     */
    @Test
    public void updateCityDetails() throws CityDetailsNotFoundException {
        City city = new City("MumbaiNew");
        City updatedCity = cityService.updateCityDetails(2, city);

        Assertions.assertEquals(2, updatedCity.getCityId());
        Assertions.assertNotNull(updatedCity);
    }


/**
 * getCityDetails
 */

/**
 * getCityDetailsByCityName
 */

/**
 * deleteCity
 */

/**
 * getAllCityDetails
 */
}
