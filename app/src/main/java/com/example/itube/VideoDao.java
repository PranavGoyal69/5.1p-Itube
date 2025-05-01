package com.example.itube;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface VideoDao {
    @Insert
    void insert(VideoItem video);

    @Query("SELECT * FROM videos")
    LiveData<List<VideoItem>> getAllVideos();
}