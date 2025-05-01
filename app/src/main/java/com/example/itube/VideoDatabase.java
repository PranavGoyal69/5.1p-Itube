package com.example.itube;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {VideoItem.class}, version = 1)
public abstract class VideoDatabase extends RoomDatabase {
    private static VideoDatabase instance;

    public abstract VideoDao videoDao();

    public static synchronized VideoDatabase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            VideoDatabase.class, "video_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}