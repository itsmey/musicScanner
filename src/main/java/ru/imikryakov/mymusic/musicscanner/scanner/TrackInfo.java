package ru.imikryakov.mymusic.musicscanner.scanner;

import java.io.File;

public class TrackInfo {
    private String path;
    private String artist;
    private String title;
    private Integer track;
    private String album;
    private String errorMsg;

    TrackInfo(String path) {
        this.path = path;
    }

    void setArtist(String artist) {
        this.artist = artist;
    }

    void setTrack(Integer track) {
        this.track = track;
    }

    void setAlbum(String album) {
        this.album = album;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    String getFolderPath() {
        return new File(path).getParent();
    }

    String getFileName() {
        return new File(path).getName();
    }

    @Override
    public String toString() {
        if (errorMsg != null) {
            return String.format("file path: %s\n" +
                    "exception: %s\n",
                    path,
                    errorMsg);
        } else {
            return String.format("folder: %s\n" +
                            "file: %s\n" +
                            "artist: %s\n" +
                            "album: %s\n" +
                            "track: %s\n" +
                            "title: %s\n",
                    getFolderPath(),
                    getFileName(),
                    artist,
                    album,
                    track,
                    title);
        }
    }
}
