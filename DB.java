package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DB {
    private static String FILE_NAME =  Paths.get("src", "main", "resources", "output.txt").toString();

    public static void save(String text) {
        try {
            File file = new File(FILE_NAME);
            file.createNewFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(text);
                writer.newLine();
            }

            System.out.println("Дані успішно записані.");
        } catch (IOException e) {
            System.out.println("очікувана помилка");
        }
    }

    public static ArrayList<String> read() {
        ClassLoader classLoader = DB.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(FILE_NAME);
             InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

             BufferedReader reader = new BufferedReader(streamReader)) {
            if (inputStream == null) {
                throw new IOException("Файл не знайдено: " + FILE_NAME);
            }

            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
