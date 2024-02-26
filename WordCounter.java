package WordCounter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) {
        String path = "d:\\sandip2\\springboot\\logical\\WordCounter\\s.text";

        try {
            String text = new String(Files.readAllBytes(Paths.get(path)));

            Long wordCount = Arrays.stream(text.split("\\s+"))
                    .filter(word -> !word.isEmpty())
                    .count();

            double avgWordLength = calAVgWordLength(text);

            System.out.println("Word Count: " + wordCount);
            System.out.println("Average word Length: " + avgWordLength);

        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    private static double calAVgWordLength(String text) {
        DoubleSummaryStatistics st = Arrays.stream(text.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.summarizingDouble(String::length));

        return st.getAverage();

    }
}
