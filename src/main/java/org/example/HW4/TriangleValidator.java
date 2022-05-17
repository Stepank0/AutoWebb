package org.example.HW4;

public class TriangleValidator implements Validator<Triangle>{


    @Override
    public boolean validate(Triangle triangle) {
        boolean valid = true;
        valid &= validPositiveSide(triangle);
        valid &= validateShape(triangle);

        return valid;
    }

    public boolean validPositiveSide(Triangle triangle){
        return triangle.sideA > 0 && triangle.sideB > 0 && triangle.sideC > 0;

    }

    public boolean validateShape (Triangle triangle){
        return  triangle.sideA < triangle.sideB + triangle.sideC &&
                triangle.sideB < triangle.sideA + triangle.sideC &&
                triangle.sideC < triangle.sideA + triangle.sideB;
    }
}
