package ru.imikryakov.mymusic.musicscanner.scanner;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class TrackVisitor extends SimpleFileVisitor<Path> {
    private ScanResult result;

    TrackVisitor(ScanResult result) {
        this.result = result;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        result.addTrack(new TrackInfo(path));
        return FileVisitResult.CONTINUE;
    }
}
