package com.geekhub.hw9.task1.thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Thread implements Runnable {
    private String links;
    private String outputFile;

    public MD5Thread(String inputFile, String outputFile) {
        this.links = inputFile;
        this.outputFile = outputFile;
    }

    private void addIntoMD5File(URL url, String md5) {
        try (FileWriter fileWriter = new FileWriter(outputFile, true)) {
            fileWriter.write(url.toString() + " : " + md5 + " \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            URL url = new URL(links);
            Object content = url.getContent();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(content.toString().getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                stringBuilder.append(String.format("%02x", b));
            }
            addIntoMD5File(url, stringBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOutputFile (String outputFile){
        File outFile = new File(outputFile);
        if (outFile.exists()) {
            outFile.delete();
        }
    }
}
