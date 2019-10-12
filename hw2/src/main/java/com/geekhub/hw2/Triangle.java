package com.geekhub.hw2;

public class Triangle extends Shape {

    private double sideALength;
    private double sideBLength;
    private double sideCLength;

    public Triangle(double sideALength, double sideBLength, double sideCLength) {
        this.sideALength = sideALength;
        this.sideBLength = sideBLength;
        this.sideCLength = sideCLength;
    }

    @Override
    public double calculateArea() {
        double halfPerimeter = calculatePerimeter() / 2.0;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideALength) * (halfPerimeter - sideBLength) *
                (halfPerimeter - sideCLength));
    }

    @Override
    public double calculatePerimeter() {
        return sideALength + sideBLength + sideCLength;
    }

    public double getSideALength() {
        return sideALength;
    }

    public double getSideBLength() {
        return sideBLength;
    }

    public double getSideCLength() {
        return sideCLength;
    }
}
