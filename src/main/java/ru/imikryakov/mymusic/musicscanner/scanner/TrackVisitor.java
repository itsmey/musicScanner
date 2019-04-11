package ru.imikryakov.mymusic.musicscanner.scanner;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class TrackVisitor extends SimpleFileVisitor<Path> {
    private List<TrackInfo> trackInfos = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        trackInfos.add(TagScanner.scan(path.toFile()));
        return FileVisitResult.CONTINUE;
    }

    List<TrackInfo> getTrackInfos() {
        return trackInfos;
    }
}
