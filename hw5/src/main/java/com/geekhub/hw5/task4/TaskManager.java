package com.geekhub.hw5.task4;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {

    public List<Task> find5NearestImportantTasks(List<Task> tasks) {
        LocalDate currentDate = LocalDate.now();
        return tasks.stream()
                .filter(task -> !task.isDone() &&
                        task.getType() == TaskType.IMPORTANT &&
                        task.getStartsOn().isAfter(currentDate))
                .sorted(Comparator.comparing(Task::getStartsOn))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<String> getUniqueCategories(List<Task> tasks) {
        return tasks.stream()
                .flatMap(task -> task.getCategories().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, List<Task>> getCategoriesWithTasks(List<Task> tasks) {
        return tasks.stream()
                .flatMap(task -> task.getCategories().stream()
                        .map(category -> new AbstractMap.SimpleEntry<>(category, task)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }

    public Map<Boolean, List<Task>> splitTasksIntoDoneAndInProgress(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.partitioningBy(Task::isDone, Collectors.toList()));
    }

    public boolean exitsTaskOfCategory(List<Task> tasks, String category) {
        return tasks.stream()
                .anyMatch(task -> task.getCategories().contains(category));
    }

    public String getTitlesOfTasks(List<Task> tasks, int startNo, int endNo) {
        return tasks.stream()
                .skip(startNo)
                .limit(endNo - startNo)
                .map(Task::getTitle)
                .collect(Collectors.joining(", "));
    }

    public Map<String, Long> getCountsByCategories(List<Task> tasks) {
        return getCategoriesWithTasks(tasks).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (long) entry.getValue().size()));
    }

    public IntSummaryStatistics getCategoriesNamesLengthStatistics(List<Task> tasks) {
        return tasks.stream()
                .flatMap(x -> x.getCategories().stream())
                .collect(Collectors.summarizingInt(String::length));
    }

    public Optional<Task> findTaskWithBiggestCountOfCategories(List<Task> tasks) {
        return tasks.stream().max(Comparator.comparingInt(t -> t.getCategories().size()));
    }
}
