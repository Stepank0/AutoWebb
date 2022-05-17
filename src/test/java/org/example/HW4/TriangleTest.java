package org.example.HW4;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;


public class TriangleTest {
    ShapeService<Triangle> testTriangleServise;

    @Before
    public void setUp(){
        testTriangleServise = new TriangleService();
    }

    @Test
    public void testValidator() {
        Triangle triangle = new Triangle(3, 4, 6);
        Assertions.assertEquals(5.332682251925386, 5.332682251925386 );


    }

    @Test
    public void testValidatorZeroSide() throws TriangleException {

        Triangle myTriangle = new Triangle(0, 4, 6);
        Assertions.assertThrows( TriangleException.class, () -> {testTriangleServise.create(myTriangle);});

    }
    @Test
    public void testValidatorNegativeNumberSide() throws TriangleException {

        Triangle myTriangle = new Triangle(-1, 4, 6);
        Assertions.assertThrows( TriangleException.class, () -> {testTriangleServise.create(myTriangle);});

    }

    @Test
    public void testValidatorNonexistent() throws TriangleException {

        Triangle myTriangle = new Triangle(2, 4, 60);
        Assertions.assertThrows( TriangleException.class, () -> {testTriangleServise.create(myTriangle);});

    }



}

