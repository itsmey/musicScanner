package ru.imikryakov.mymusic.musicscanner.scanner;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class ScanResult {
    private Map<String, TrackInfo> storage = new HashMap<>();

    void addTrack(TrackInfo track) {
        storage.put(track.getPath().toString(), track);
    }

    public void printVerboseDescriptions(PrintStream os) {
        for (TrackInfo track : storage.values()) {
            os.println(track.getVerboseDescription());
        }
    }
}
