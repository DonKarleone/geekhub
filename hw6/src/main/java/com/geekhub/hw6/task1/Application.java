package com.geekhub.hw6.task1;

import java.io.*;

public class Application {

    public static void main(String[] args) throws IOException {
        final int MAX_WORD_LENGTH = 9;

        File inputFile = new File("hw6/src/main/resources/task1/input.txt");
        File outpuFile = new File("hw6/src/main/resources/task1/output.txt");
        StringBuilder accumulator = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        if (inputFile.exists()) {
            InputStream in = new FileInputStream(inputFile);
            int data;
            while ((data = in.read()) != -1) {
                if (Character.isLetter((char) data)) {
                    accumulator.append((char) data);
                } else {
                    String word = convertWord(accumulator, MAX_WORD_LENGTH);
                    accumulator.setLength(0);
                    resultBuilder.append(word);
                    resultBuilder.append((char) data);
                }
            }
            String word = convertWord(accumulator, MAX_WORD_LENGTH);
            resultBuilder.append(word);
            in.close();
            PutStringBuilderToFile(outpuFile, resultBuilder);
            System.out.println("Input file - " + inputFile.getAbsolutePath());
            System.out.println("Output file - " + outpuFile.getAbsolutePath());
        } else {
            System.out.println("Input file - " + inputFile.getAbsolutePath() + " does not exist.");
        }
    }

    private static String convertWord(StringBuilder acc, int maxWordLength) {
        String word = acc.toString();
        if (word.length() > maxWordLength) {
            word = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
        }
        return word;
    }

    private static void PutStringBuilderToFile(File outpuFile, StringBuilder stringBuilder) {
        if (!outpuFile.exists()) {
            try {
                outpuFile.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try (PrintWriter out = new PrintWriter(outpuFile.getAbsoluteFile())) {
            out.print(stringBuilder);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
