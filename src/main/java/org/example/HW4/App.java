package org.example.HW4;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try {
            calculatedSquare();
        } catch (TriangleException e) {
            throw new RuntimeException(e);
        }


    }

    public static double calculatedSquare () throws  TriangleException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите три целочисленных числа," +
                " для обозначения трёх сторон треугольника");

        double result = 0;
        while (scan.hasNextInt()) {

            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            Triangle myTriangle = new Triangle(a, b, c);
            ShapeService<Triangle> triangleService = new TriangleService();



            try {
                myTriangle = triangleService.create(myTriangle);
                double p = (double) ((a + b + c) / 2.0);
                double S = (double) (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                System.out.println(" Площадь треугольника равна : " + S);
                result = S;
                scan.close();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return result;
    }


}