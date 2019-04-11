package ru.imikryakov.mymusic.musicscanner.exporter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MusicCollection {
    private Set<Artist> artists;
    private Set<Album> albums;
    private Set<Track> track;

    public class Artist {
        private String name;
        private Set<Album> albums;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Artist artist = (Artist) o;
            return name.equals(artist.name) &&
                    Objects.equals(albums, artist.albums);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, albums);
        }
    }

    public class Album {
        private String title;
        private Artist artist;
        private Set<Track> tracks;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Album album = (Album) o;
            return title.equals(album.title) &&
                    Objects.equals(artist, album.artist);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, artist);
        }
    }

    public class Track {
        private int number;
        private int title;
        private Album album;
        private Artist artist;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Track track = (Track) o;
            return number == track.number &&
                    title == track.title &&
                    Objects.equals(album, track.album) &&
                    Objects.equals(artist, track.artist);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, title, album, artist);
        }
    }
}
