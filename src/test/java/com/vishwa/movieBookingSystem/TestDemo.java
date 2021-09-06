package com.vishwa.movieBookingSystem;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.tool.schema.SourceType;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.junit.jupiter.api.*;

import java.sql.SQLOutput;

public class TestDemo {
/**
 * I want to execute something only once, in the beginning
 */
@BeforeAll
public static void veryBeginning(){
    System.out.println("In the very beginning");
}
    /**
     * Before running any test, we do some preparation
     */
    @BeforeEach
    public void beforeEachTestMethod() {
        System.out.println("Before each test");
    }

    /**
     * I want to execute something after every test is executed
     */
    @AfterEach
    public void afterEachTestMethod() {
        System.out.println("After each test");
    }

    @Test
    public void myFirstTest() {
        System.out.println("Inside the first test");

    }

    @Test
    public void mySecondTest() {
        System.out.println("Inside the Second Test");
    }
    /**
     * I want to execute something in the very end
     */
    @AfterAll
    public static void lastMethod(){
        System.out.println("In the very end");
    }
}
