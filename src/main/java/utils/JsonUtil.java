package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Convert JSON file to a java obj (pojo)
     */
    public static <T> T fromJsonFile(String filePath, Class<T> clazz) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }

    /**
     * Convert Java object to JSON string (pretty)
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }


}
