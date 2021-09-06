package com.vishwa.movieBookingSystem;

import com.vishwa.movieBookingSystem.services.InitService;
import com.vishwa.movieBookingSystem.services.MovieService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MovieBookingSystemApplication {
    /**
     * We need the Logger Object
     */
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MovieBookingSystemApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

        System.out.println("Hello Spring Boot !!! ");
      //MovieService movieService = ctx.getBean(MovieService.class);

        LOGGER.debug("Writing for debug");
        LOGGER.info("Writing for info");
        LOGGER.warn("Writing for warn");
        LOGGER.error("Writing for Error");

    }

    /**
     * This is way to execute something in the very beginning when application
     * is starting up
     */
    @Bean
    CommandLineRunner init(InitService initService) {
        return args -> {
            System.out.println("This will be executed as soon as the application is started");
            initService.init();
        };
    }

    /**
     * This will store the manually created object as a Bean in the spring
     * controller
     *
     */
    @Bean
public ModelMapper modelMapper(){
        return new ModelMapper();
}

}
