package com.geekhub.hw2;

public class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public Triangle getTriangleSides() {
        double hypotenuse = Math.sqrt(2.0) * sideLength;
        return new Triangle(sideLength, sideLength, hypotenuse);
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    @Override
    public double calculatePerimeter() {
        return 4.0 * sideLength;
    }
}
