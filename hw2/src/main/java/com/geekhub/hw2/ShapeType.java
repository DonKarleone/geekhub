package com.geekhub.hw2;

public enum ShapeType {
    CIRCLE("Circle"),
    RECTANGLE("Rectangle"),
    TRIANGLE("Triangle"),
    SQUARE("Square");

    private String stringRepresentation;

    ShapeType(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }

    public static ShapeType fromString(String inputString) {
        for (ShapeType acceptableValue : ShapeType.values()) {
            if (acceptableValue.stringRepresentation.equalsIgnoreCase(inputString)) {
                return acceptableValue;
            }
        }
        return null;
    }
}
