package com.geekhub.hw10.task2;

import java.time.LocalDateTime;

public class Feedback {

    private String name;
    private String text;
    private LocalDateTime date;
    private Integer rank;

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    LocalDateTime getDate() {
        return date;
    }

    void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getRank() {
        return rank;
    }

    void setRank(Integer rank) {
        this.rank = rank;
    }
}
