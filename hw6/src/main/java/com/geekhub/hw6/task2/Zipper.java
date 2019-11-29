package com.geekhub.hw6.task2;

import java.io.IOException;
import java.util.*;

public class Zipper {
    public static void main(String[] args) throws IOException {
        String sourceDirPath = "hw6/src/main/resources/task2/";
        Set<String> videos = new HashSet<>(Arrays.asList(".avi", ".mp4", ".flv"));
        Set<String> audios = new HashSet<>(Arrays.asList(".mp3", ".wav", ".wma"));
        Set<String> images = new HashSet<>(Arrays.asList(".jpeg", "jpg", ".gif", ".pnd"));
        PackByType.pack(sourceDirPath, sourceDirPath + "videos.zip", videos);
        PackByType.pack(sourceDirPath, sourceDirPath + "audios.zip", audios);
        PackByType.pack(sourceDirPath, sourceDirPath + "images.zip", images);
    }
}
