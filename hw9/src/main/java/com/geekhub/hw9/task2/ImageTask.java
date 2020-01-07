package com.geekhub.hw9.task2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Represents worker that downloads image from URL to specified folder.<br/>
 * Name of the image will be constructed based on URL. Names for the same URL will be the same.
 */
public class ImageTask implements Runnable {

    private final URL url;
    private final String folder;

    /**
     * Inherited method that do main job - downloads the image and stores it at specified location
     */
    public ImageTask(URL url, String folder) {
        this.url = url;
        this.folder = folder;
    }

    /**
     * Inherited method that do main job - downloads the image and stores it at specified location
     */
    @Override
    public void run() {
        try (InputStream in = url.openStream()) {
            Files.copy(in, (Paths.get(folder + "\\" + System.nanoTime() + buildFileName(url))));
        } catch (IOException e) {
            System.out.println("IOException");
        }
        //This method downloads image from the specified url and saves the image to the given folder
    }

    //converts URL to unique file name
    private String buildFileName(URL url) {
        return url.toString().replaceAll("[^a-zA-Z0-9-_.]", "_");
    }
}
