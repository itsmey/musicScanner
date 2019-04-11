package ru.imikryakov.mymusic.musicscanner.scanner;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;

public class ID3v1FetcherImpl implements TrackInfoFetcher {
    ID3v1 tag;

    @Override
    public void fillTrackInfo(Mp3File mp3, TrackInfo trackInfo) {
        if (mp3.hasId3v1Tag()) {
            tag = mp3.getId3v1Tag();
            overwriteAll(trackInfo);
        }
    }

    private Integer fetchTrack() {
        String trackStr = tag.getTrack();
        if (trackStr == null) {
            return null;
        }
        try {
            return Integer.valueOf(trackStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String fetchArtist() {
        return tag.getArtist();
    }

    private String fetchAlbum() {
        return tag.getAlbum();
    }

    private String fetchTitle() {
        return tag.getTitle();
    }

    void overwriteAll(TrackInfo trackInfo) {
        Integer track = fetchTrack();
        String artist = fetchArtist();
        String album = fetchAlbum();
        String title = fetchTitle();
        if (track != null) {
            trackInfo.setTrack(fetchTrack());
        }
        if (artist != null && !artist.isEmpty()) {
            trackInfo.setArtist(fetchArtist());
        }
        if (album != null && !album.isEmpty()) {
            trackInfo.setAlbum(fetchAlbum());
        }
        if (title != null && !title.isEmpty()) {
            trackInfo.setTitle(fetchTitle());
        }
    }
}
