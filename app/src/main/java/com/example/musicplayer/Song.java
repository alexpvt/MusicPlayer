package com.example.musicplayer;

public class Song {
    private int id;
    private String title, artist, url;

    public Song(int id, String title, String artist, String url) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }
}
