package ru.imikryakov.mymusic.musicscanner.scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class TrackScanner {

    static ScanResult walk(Path path) {
        ScanResult result = new ScanResult();
        TrackVisitor visitor = new TrackVisitor(result);
        try {
            Files.walkFileTree(path, visitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
