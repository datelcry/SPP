package by.bsuir.project.util;

import java.nio.charset.StandardCharsets;

/**
 * Created by User on 20.05.2017.
 */
public class Charset {
    public static String change(String text) {
        byte[] bytes = text.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
