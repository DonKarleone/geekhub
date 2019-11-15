package com.geekhub.hw5.task4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task(1, TaskType.IMPORTANT, "Title A", true, new HashSet<>(Arrays.asList("Cat A", "Cat B1", "Cat C", "Cat D")), LocalDate.of(2019, 11, 20)),
                new Task(2, TaskType.OPTIONAL, "Title B", false, new HashSet<>(Arrays.asList("Cat ABC")), LocalDate.of(2019, 11, 17)),
                new Task(3, TaskType.IMPORTANT, "Title C", true, new HashSet<>(Arrays.asList("Cat C", "Cat B")), LocalDate.of(2019, 11, 29)),
                new Task(4, TaskType.IMPORTANT, "Title D", false, new HashSet<>(Arrays.asList("Cat D", "Cat B")), LocalDate.of(2019, 11, 22)),
                new Task(5, TaskType.IMPORTANT, "Title E", false, new HashSet<>(Arrays.asList("Cat C", "Cat A")), LocalDate.of(2019, 12, 1)),
                new Task(6, TaskType.IMPORTANT, "Title F", false, new HashSet<>(Arrays.asList("Cat A", "Cat B", "Cat D")), LocalDate.of(2019, 11, 17)),
                new Task(7, TaskType.IMPORTANT, "Title G", false, new HashSet<>(Arrays.asList("Cat A", "Cat C", "Cat E")), LocalDate.of(2019, 11, 24)),
                new Task(8, TaskType.PRIMARY, "Title H", true, new HashSet<>(Arrays.asList("Cat B", "Cat E", "Cat A")), LocalDate.of(2019, 12, 3)),
                new Task(9, TaskType.PRIMARY, "Title I", true, new HashSet<>(Arrays.asList("Cat A", "Cat B", "Cat C")), LocalDate.of(2019, 11, 22)),
                new Task(10, TaskType.IMPORTANT, "Title J", false, new HashSet<>(Arrays.asList("Cat A", "Cat B", "Cat C", "Cat D")), LocalDate.of(2019, 12, 5)),
                new Task(11, TaskType.IMPORTANT, "Title K", true, new HashSet<>(Arrays.asList("Cat A", "Cat B", "Cat E", "Cat D")), LocalDate.of(2019, 11, 23)),
                new Task(12, TaskType.IMPORTANT, "Title L", true, new HashSet<>(Arrays.asList("Cat A", "Cat B")), LocalDate.of(2019, 12, 2)),
                new Task(13, TaskType.OPTIONAL, "Title M", false, new HashSet<>(Arrays.asList("Cat D", "Cat B", "Cat C")), LocalDate.of(2019, 12, 5)),
                new Task(14, TaskType.PRIMARY, "Title N", false, new HashSet<>(Arrays.asList("Cat A", "Cat E", "Cat C", "Cat D")), LocalDate.of(2018, 11, 30)),
                new Task(15, TaskType.IMPORTANT, "Title O", true, new HashSet<>(Arrays.asList("Cat A", "Cat E")), LocalDate.of(2019, 11, 26)),
                new Task(16, TaskType.IMPORTANT, "Title P", false, new HashSet<>(Arrays.asList("Cat A", "Cat B1", "Cat C", "Cat D")), LocalDate.of(2019, 11, 17)),
                new Task(17, TaskType.OPTIONAL, "Title Q", false, new HashSet<>(Arrays.asList("Cat ABC", "Cat B", "Cat C")), LocalDate.of(2019, 10, 13)),
                new Task(18, TaskType.OPTIONAL, "Title R", true, new HashSet<>(Arrays.asList("Cat A", "Cat B1", "Cat E", "Cat D")), LocalDate.of(2019, 10, 22)),
                new Task(19, TaskType.IMPORTANT, "Title S", true, new HashSet<>(Arrays.asList("Cat A", "Cat B1", "Cat C", "Cat D")), LocalDate.of(2019, 12, 28)),
                new Task(20, TaskType.IMPORTANT, "Title T", false, new HashSet<>(Arrays.asList("Cat C")), LocalDate.of(2019, 10, 9)),
                new Task(21, TaskType.IMPORTANT, "Title U", true, new HashSet<>(Arrays.asList("Cat E")), LocalDate.of(2019, 11, 15))
        );

        TaskManager taskManager = new TaskManager();

        System.out.println("\n===> find5NearestImportantTasks");
        taskManager.find5NearestImportantTasks(tasks).forEach(System.out::println);

        System.out.println("\n ===> getUniqueCategories");
        taskManager.getUniqueCategories(tasks).forEach(System.out::println);

        System.out.println("\n===> getCategoriesWithTasks");
        taskManager.getCategoriesWithTasks(tasks).entrySet().forEach(System.out::println);

        System.out.println("\n===> splitTasksIntoDoneAndInProgress");
        taskManager.splitTasksIntoDoneAndInProgress(tasks).entrySet().forEach(System.out::println);

        System.out.println("\n===> exitsTaskOfCategory");
        System.out.println("Cat E exist: " + taskManager.exitsTaskOfCategory(tasks, "Cat E"));
        System.out.println("Cat F exist: " + taskManager.exitsTaskOfCategory(tasks, "Cat F"));

        System.out.println("\n===> getTitlesOfTasks");
        System.out.println(taskManager.getTitlesOfTasks(tasks, 10, 20));

        System.out.println("\n===> getCountsByCategories");
        taskManager.getCountsByCategories(tasks).entrySet().forEach(System.out::println);

        System.out.println("\n===> getCategoriesNamesLengthStatistics");
        System.out.println(taskManager.getCategoriesNamesLengthStatistics(tasks));

        System.out.println("\n===> findTaskWithBiggestCountOfCategories");
        System.out.println(taskManager.findTaskWithBiggestCountOfCategories(tasks));
    }
}
