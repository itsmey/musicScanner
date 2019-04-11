package ru.imikryakov.mymusic.musicscanner.scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class TrackVisitor extends SimpleFileVisitor<Path> {
    private static Logger logger = LoggerFactory.getLogger(TrackVisitor.class);

    private ScanResult result;

    TrackVisitor(ScanResult result) {
        this.result = result;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        logger.info("visiting file {}", path);
        result.addTrack(new TrackInfo(path));
        return FileVisitResult.CONTINUE;
    }
}
