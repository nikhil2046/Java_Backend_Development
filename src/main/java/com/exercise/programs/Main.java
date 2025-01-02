package com.exercise.programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String result = "Hello, World!";
        String htmlOutput = generateHtml(result);

        // Write the HTML output to a file
        String filePath = "output.html";
        writeHtmlToFile(filePath, htmlOutput);

        // Open the file in the default browser (manually)
        System.out.println("HTML content written to " + filePath + ". Open it in your browser to view.");
    }

    public static String generateHtml(String content) {
        return "<html>\n" +
                "  <head>\n" +
                "    <title>Java Program Output</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h1>" + content + "</h1>\n" +
                "  </body>\n" +
                "</html>";
    }

    public static void writeHtmlToFile(String filePath, String htmlContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(htmlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
