package com.geekhub.hw2;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String userInput;
        Scanner in = new Scanner(System.in);
        inputMessage();
        userInput = in.next();
        ShapeType shapeType = ShapeType.fromString(userInput);
        if (shapeType == null) {
            System.out.println("Invalid shape type.");
        } else {
            switch(shapeType) {
                case CIRCLE:
                    calculateCircle(in);
                    break;
                case RECTANGLE:
                    calculateRectangle(in);
                    break;
                case SQUARE:
                    calculateSquare(in);
                    break;
                case TRIANGLE:
                    calculateTriangle(in);
                    break;
            }
        }
    }

    private static void inputMessage() {
        System.out.println("Enter shape name.");
        System.out.println("Available shapes:");
        for (ShapeType shapeType : ShapeType.values()) {
            System.out.println(" - " + shapeType.toString());
        }
    }

    private static void calculateCircle(Scanner in) {
        System.out.print("Radius: ");
        double radius = in.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
    }

    private static void calculateRectangle(Scanner in) {
        System.out.print("Width: ");
        double width = in.nextDouble();
        System.out.print("Height: ");
        double height = in.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        Triangle triangle = rectangle.getTriangleSides();
        System.out.println("Triangle sides: " + triangle.getSideALength() + ", " + triangle.getSideBLength() + ", " +
                triangle.getSideCLength());
        System.out.println("Triangle area: " + triangle.calculateArea());
        System.out.println("Triangle perimeter: " + triangle.calculatePerimeter());
    }

    private static void calculateSquare(Scanner in) {
        System.out.print("Side lenght: ");
        double sideLenght = in.nextDouble();
        Square square = new Square(sideLenght);
        System.out.println("Area: " + square.calculateArea());
        System.out.println("Perimeter: " + square.calculatePerimeter());
        Triangle triangle = square.getTriangleSides();
        System.out.println("Triangle sides: " + triangle.getSideALength() + ", " + triangle.getSideBLength() + ", " +
                triangle.getSideCLength());
        System.out.println("Triangle area: " + triangle.calculateArea());
        System.out.println("Triangle perimeter: " + triangle.calculatePerimeter());
    }

    private static void calculateTriangle(Scanner in) {
        System.out.print("Side A: ");
        double sideA = in.nextDouble();
        System.out.print("Side B: ");
        double sideB = in.nextDouble();
        System.out.print("Side C: ");
        double sideC = in.nextDouble();
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        System.out.println("Area: " + triangle.calculateArea());
        System.out.println("Perimeter: " + triangle.calculatePerimeter());
    }
}
