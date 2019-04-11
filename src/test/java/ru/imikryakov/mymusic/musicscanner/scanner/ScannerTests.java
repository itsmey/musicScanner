package ru.imikryakov.mymusic.musicscanner.scanner;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;

public class ScannerTests {
    private final String SAMPLES_FOLEDER_NAME = "samples";

    @Test
    public void printVerboseDescriptionsFromTestFolder() {
        ClassLoader classLoader = ScannerTests.class.getClassLoader();
        Path path = new File(classLoader.getResource(SAMPLES_FOLEDER_NAME).getFile()).toPath();
        TrackScanner.walk(path).printVerboseDescriptions(System.out);
    }
}
