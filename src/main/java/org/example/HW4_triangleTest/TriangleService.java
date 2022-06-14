package org.example.HW4_triangleTest;

public class TriangleService implements ShapeService<Triangle>{

    private final Validator<Triangle> Validator;

    public TriangleService() {
        Validator = new TriangleValidator();
    }

//    @Override
//    public Triangle create(int a, int b, int c) throws TriangleException {
//        Triangle triangle = new Triangle(a, b, c);
//        if (Validator.validate(triangle)){
//            return triangle;
//        }
//            throw new TriangleException("Triangle is not valid");
//    }

    @Override
    public Triangle create(Triangle triangle) throws TriangleException {
        if (Validator.validate(triangle)){
            return triangle;
        }
        throw new TriangleException("Triangle is not valid");
    }


}
