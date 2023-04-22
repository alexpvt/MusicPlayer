package com.example.musicplayer;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;

public class SongRepository {
    private static final String BASE_URL = "https://www.songsterr.com/a/wa/api/";
    private final ApiService apiService;

    public SongRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public LiveData<List<Song>> getSongs() {
        MutableLiveData<List<Song>> data = new MutableLiveData<>();
        apiService.getSongs().enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(@NonNull Call<List<Song>> call, @NonNull Response<List<Song>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Song>> call, @EverythingIsNonNull Throwable t) {
                Log.e("SongRepository", "Failed to get songs", t);
            }
        });
        return data;
    }

}
