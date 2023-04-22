package com.example.musicplayer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class SongViewModel extends ViewModel {
    private final LiveData<List<Song>> songs;

    public SongViewModel() {
        SongRepository repository = new SongRepository();
        songs = repository.getSongs();
    }

    public LiveData<List<Song>> getSongs() {
        return songs;
    }

}
