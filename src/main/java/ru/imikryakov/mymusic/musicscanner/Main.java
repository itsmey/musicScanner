package ru.imikryakov.mymusic.musicscanner;


import ru.imikryakov.mymusic.musicscanner.scanner.TagScanner;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            File file = new File(classLoader.getResource("samples").getFile());

            System.out.println(TagScanner.walk(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
