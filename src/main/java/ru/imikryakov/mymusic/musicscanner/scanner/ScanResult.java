package ru.imikryakov.mymusic.musicscanner.scanner;

import java.util.List;

class ScanResult {
    private List<TrackInfo> trackInfos;

    ScanResult(List<TrackInfo> trackInfos) {
        this.trackInfos = trackInfos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TrackInfo trackInfo : trackInfos) {
            stringBuilder.append(trackInfo.toString());
        }
        return stringBuilder.toString();
    }
}
