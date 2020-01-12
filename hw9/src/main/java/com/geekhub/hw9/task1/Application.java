package com.geekhub.hw9.task1;

import com.geekhub.hw9.task1.fileUtils.FileUtils;
import com.geekhub.hw9.task1.thread.MD5Thread;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        String inputFile = "hw9/src/main/resources/task1/links.txt";
        String outputFile = "hw9/src/main/resources/task1/md5.txt";
        List<Callable<String>> md5Threads = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(inputFile))) {
            FileUtils.deleteOutputFile(outputFile);
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            while (scanner.hasNext()) {
                md5Threads.add(new MD5Thread(scanner.nextLine()));
            }
            for (Future<String> stringToWrite : executorService.invokeAll(md5Threads)) {
                FileUtils.addIntoMD5File(stringToWrite.get(), outputFile);
            }
            executorService.shutdown();
        }
    }
}
