package com.example.itube;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "videos")
public class VideoItem {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String videoUrl;
    public String title;
}