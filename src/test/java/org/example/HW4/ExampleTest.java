package org.example.HW4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    static Logger logger = LoggerFactory.getLogger(ExampleTest.class);

    Integer repeated = 0;

    @Test
    @Disabled("demonstration")
    @Order(1)
    public void simpleTest(){

        assertTrue(true);

    }


    @Test
    void  myTest(){
        System.out.println(" My test");
    }
}
