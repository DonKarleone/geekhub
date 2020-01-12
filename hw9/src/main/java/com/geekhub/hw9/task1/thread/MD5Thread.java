package com.geekhub.hw9.task1.thread;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

public class MD5Thread implements Callable {
    private String link;

    public MD5Thread(String link) {
        this.link = link;
    }

    @Override
    public String call() throws IOException, NoSuchAlgorithmException {
        StringBuilder stringBuilder = new StringBuilder();
        URL url = new URL(link);
        Object content = url.getContent();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest(content.toString().getBytes());
        for (byte b : digest) {
            stringBuilder.append(String.format("%02x", b));
        }
        return url.toString() + " : " + stringBuilder.toString() + " \n";
    }
}
