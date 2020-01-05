package com.geekhub.hw9.task1;

import com.geekhub.hw9.task1.thread.MD5Thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static String inputFile = "hw9/src/main/java/com/geekhub/hw9/task1/links/links.txt";
    public static String outputFile = "hw9/src/main/java/com/geekhub/hw9/task1/links/md5.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader(inputFile))) {
            MD5Thread.deleteOutputFile(outputFile);
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            while (scanner.hasNext()) {
                executorService.submit(new MD5Thread((scanner.nextLine()), outputFile));
            }
            executorService.shutdown();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
