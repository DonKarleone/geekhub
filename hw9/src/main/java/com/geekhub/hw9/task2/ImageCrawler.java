package com.geekhub.hw9.task2;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ImageCrawler downloads all images to specified folder from specified resource.
 * It uses multi threading to make process faster. To start download images you should call downloadImages(String urlToPage) method with URL.
 * To shutdown the service you should call stop() method
 */
public class ImageCrawler {

    private final ExecutorService executorService;
    private final String folder;

    public ImageCrawler(int numberOfThreads, String folder) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
        //Create an executor service with given number of threads
        this.folder = folder;
    }

    /**
     * Call this method to start download images from specified URL.
     *
     * @param urlToPage
     * @throws java.io.IOException
     */
    public void downloadImages(String urlToPage) throws IOException {
        Page page = new Page(new URL(urlToPage));
        List<URL> links = (List<URL>) page.getImageLinks();
        for (URL link : links) {
            if (isImageURL(link)) {
                executorService.submit(new ImageTask(link, folder));
            }
        }
        //Submit each url from the page as an image task to the executor service
    }

    /**
     * Call this method before shutdown an application
     */
    public void stop() {
        executorService.shutdown();
        //Find out how to stop the executor service properly
    }

    //detects is current url is an image. Checking for popular extensions should be enough
    private boolean isImageURL(URL url) {
        return url.toString().matches("([^\\s]+(\\.(?i)(jpg|png))$)");
    }
}