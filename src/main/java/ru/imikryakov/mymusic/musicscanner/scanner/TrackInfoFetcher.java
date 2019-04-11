package ru.imikryakov.mymusic.musicscanner.scanner;

import com.mpatric.mp3agic.Mp3File;

public interface TrackInfoFetcher {
    void fillTrackInfo(Mp3File mp3, TrackInfo trackInfo);
}
