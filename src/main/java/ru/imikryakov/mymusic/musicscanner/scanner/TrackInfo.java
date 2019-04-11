package ru.imikryakov.mymusic.musicscanner.scanner;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import java.nio.file.Path;

class TrackInfo {
    private Path path;
    private String parentFolder;
    private String filename;
    private String errorMsg;
    private Mp3File tag;

    TrackInfo(Path path) {
        this.path = path;
        parentFolder = path.getParent().toString();
        filename = path.getFileName().toString();
        try {
            tag = new Mp3File(path);
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
    }

    Path getPath() {
        return path;
    }

    String getVerboseDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("folder: %s\n", parentFolder));
        sb.append(String.format("file name: %s\n", filename));
        if (errorMsg != null) {
            sb.append(String.format("is broken: %s\n", errorMsg));
        } else {
            if (tag.hasId3v1Tag()) {
                ID3v1 id3v1 = tag.getId3v1Tag();
                sb.append("id3v1 tag:\n");
                addID3v1Info(sb, id3v1);
            } else {
                sb.append("no id3v1 tag found!\n");
            }
            if (tag.hasId3v2Tag()) {
                ID3v2 id3v2 = tag.getId3v2Tag();
                sb.append("id3v2 tag:\n");
                addID3v1Info(sb, id3v2);
                sb.append(String.format("album artist: %s\n", id3v2.getAlbumArtist()));
            } else {
                sb.append("no id3v2 tag found!\n");
            }
        }

        return sb.toString();
    }

    private void addID3v1Info(StringBuilder sb, ID3v1 id3v1or2) {
        sb.append(String.format("album: %s\n", id3v1or2.getAlbum()));
        sb.append(String.format("artist: %s\n", id3v1or2.getArtist()));
        sb.append(String.format("track: %s\n", id3v1or2.getTrack()));
        sb.append(String.format("title: %s\n", id3v1or2.getTitle()));
    }
}
