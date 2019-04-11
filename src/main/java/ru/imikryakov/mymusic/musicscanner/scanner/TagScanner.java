package ru.imikryakov.mymusic.musicscanner.scanner;

import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TagScanner {
    private static TrackInfoFetcher id3v1fetcher = new ID3v1FetcherImpl();
    private static TrackInfoFetcher id3v2fetcher = new ID3v2FetcherImpl();

    static TrackInfo scan(File file) {
        String path = file.getPath();
        TrackInfo trackInfo = new TrackInfo(path);

        try {
            Mp3File mp3file = new Mp3File(file);
            id3v1fetcher.fillTrackInfo(mp3file, trackInfo);
            id3v2fetcher.fillTrackInfo(mp3file, trackInfo);
        } catch (Exception e) {
            trackInfo.setErrorMsg(e.getMessage());
            return trackInfo;
        }

        return trackInfo;
    }

    public static ScanResult walk(File file) {
        TrackVisitor visitor = new TrackVisitor();
        try {
            Files.walkFileTree(file.toPath(), visitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ScanResult(visitor.getTrackInfos());
    }
}
