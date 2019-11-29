package com.geekhub.hw6.task2;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

class PackByType {
    static void pack(String sourceDirPath, String zipFilePath, Set<String> typeFiles) throws IOException {
        File zipFile = new File(zipFilePath);
        if (zipFile.exists()) {
            zipFile.delete();
        }
        Path newFile = Files.createFile(Paths.get(zipFilePath));
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(newFile))) {
            Path sourcePath = Paths.get(sourceDirPath);
            Files.walk(sourcePath)
                    .filter(path -> !Files.isDirectory(path))
                    .filter(path -> typeFiles.stream()
                            .anyMatch(extension -> sourcePath.relativize(path).toString().endsWith(extension)))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(sourcePath.relativize(path).toString());
                        try {
                            zos.putNextEntry(zipEntry);
                            Files.copy(path, zos);
                            zos.closeEntry();
                        } catch (IOException e) {
                            System.err.println(e);
                        }
                    });
        }
    }
}


