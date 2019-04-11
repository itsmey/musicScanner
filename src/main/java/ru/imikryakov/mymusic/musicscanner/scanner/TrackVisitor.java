package ru.imikryakov.mymusic.musicscanner.scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TrackVisitor extends SimpleFileVisitor<Path> {
    private static Logger logger = LoggerFactory.getLogger(TrackVisitor.class);

    private PathMatcher MP3_MATCHER = FileSystems.getDefault().getPathMatcher("glob:*.mp3");

    private ScanResult result;

    TrackVisitor(ScanResult result) {
        this.result = result;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        logger.info("visiting file {}", path);
        if (!MP3_MATCHER.matches(path.getFileName())) {
            logger.info("not an MP3! skip");
            return FileVisitResult.CONTINUE;
        }
        result.addTrack(new TrackInfo(path));
        return FileVisitResult.CONTINUE;
    }
}
