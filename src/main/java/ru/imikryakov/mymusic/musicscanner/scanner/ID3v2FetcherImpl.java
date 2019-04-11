package ru.imikryakov.mymusic.musicscanner.scanner;

import com.mpatric.mp3agic.Mp3File;

public class ID3v2FetcherImpl extends ID3v1FetcherImpl {
    @Override
    public void fillTrackInfo(Mp3File mp3, TrackInfo trackInfo) {
        if (mp3.hasId3v2Tag()) {
            tag = mp3.getId3v2Tag();
            overwriteAll(trackInfo);
        }
    }
}
