package com.geekhub.hw5.task2;

public enum Direction {
    ASC(1), DESC(-1);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return this.direction;
    }
}
