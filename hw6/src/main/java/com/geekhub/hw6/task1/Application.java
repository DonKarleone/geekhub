package com.geekhub.hw6.task1;

import java.io.*;

public class Application {

    public static void main(String[] args) throws IOException {
        final int MAX_WORD_LENGTH = 9;

        File inputFile = new File("hw6/src/main/resources/task1/input.txt");
        File outpuFile = new File("hw6/src/main/resources/task1/output.txt");
        if (!inputFile.exists()) {
            System.out.println("Input file - " + inputFile.getAbsolutePath() + " does not exist.");
        }
        StringBuilder resultBuilder = GetConvertedStringFromFile(inputFile, MAX_WORD_LENGTH);
        PutStringBuilderToFile(outpuFile, resultBuilder);
        System.out.println("Input file - " + inputFile.getAbsolutePath());
        System.out.println("Output file - " + outpuFile.getAbsolutePath());
    }

    private static String convertWord(StringBuilder acc, int maxWordLength) {
        String word = acc.toString();
        if (word.length() > maxWordLength) {
            word = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
        }
        return word;
    }

    private static void PutStringBuilderToFile(File outputFile, StringBuilder stringBuilder) {
        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try (PrintWriter out = new PrintWriter(outputFile.getAbsoluteFile())) {
            out.print(stringBuilder);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static StringBuilder GetConvertedStringFromFile(File inputFile, int maxWordLength) {
        StringBuilder accumulator = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        try (InputStream in = new FileInputStream(inputFile)) {
            int data;
            while ((data = in.read()) != -1) {
                if (Character.isLetter((char) data)) {
                    accumulator.append((char) data);
                } else {
                    String word = convertWord(accumulator, maxWordLength);
                    accumulator.setLength(0);
                    resultBuilder.append(word);
                    resultBuilder.append((char) data);
                }
            }
            String word = convertWord(accumulator, maxWordLength);
            resultBuilder.append(word);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resultBuilder;
    }
}
