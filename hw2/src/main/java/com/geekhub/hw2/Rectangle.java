package com.geekhub.hw2;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Triangle getTriangleSides() {
        double hypotenuse = Math.sqrt(width * width + height * height);
        return new Triangle(width, height, hypotenuse);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2.0 * (width + height);
    }

}
