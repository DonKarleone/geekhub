package com.geekhub.hw9.task2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Application {

    public static void main(String[] args) throws IOException {
        int threadNumder = 10;
        String outputFolder = "hw9/src/main/resources/task2/";
        if (!new File(outputFolder).exists()) {
            new File(outputFolder).mkdirs();
        }
        FileUtils.cleanDirectory(new File(outputFolder));
        ImageCrawler imageCrawler = new ImageCrawler(threadNumder, outputFolder);
        imageCrawler.downloadImages("https://ruinmyweek.com/funny/best-funny-pictures-48/");

        System.out.println("While it's loading you can enter another url to start download images:");

        Scanner scanner = new Scanner(System.in);
        String command;
        while (!"exit".equals(command = scanner.next())) {
            imageCrawler.downloadImages(command);
            System.out.println("...and another url:");
        }
        imageCrawler.stop();
    }
}
