package com.geekhub.hw9.task1.fileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void deleteOutputFile(String outputFile) {
        new File(outputFile).delete();
    }

    public static void addIntoMD5File(String stringToWrite, String outputFile) throws IOException {
        try (FileWriter fileWriter = new FileWriter(outputFile, true)) {
            fileWriter.write(stringToWrite);
        }
    }
}
