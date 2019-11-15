package com.geekhub.hw5.task4;

import java.time.LocalDate;
import java.util.Set;

public class Task {

    private int id;
    private TaskType type;
    private String title;
    private boolean done;
    private Set<String> categories;
    private LocalDate startsOn;

    public Task(int id, TaskType type, String title, boolean done, Set<String> categories, LocalDate startsOn) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.done = done;
        this.categories = categories;
        this.startsOn = startsOn;
    }

    public TaskType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public LocalDate getStartsOn() {
        return startsOn;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", done=" + done +
                ", categories=" + categories +
                ", startsOn=" + startsOn +
                '}';
    }
}
