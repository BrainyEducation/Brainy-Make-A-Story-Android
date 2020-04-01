package com.example.make_a_story_prototype.main.data;

import android.content.Context;

import com.example.make_a_story_prototype.main.data.Story.db.Blank;
import com.example.make_a_story_prototype.main.data.Story.db.TextSegment;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {TextSegment.class, Blank.class}, version = 1, exportSchema = false)
public abstract class BrainyDatabase extends RoomDatabase {

    private static BrainyDatabase instance;

    public abstract TextSegmentDao textSegmentDao();
    public abstract BlankDao blankDao();

    public static synchronized BrainyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BrainyDatabase.class, "brainy_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

}
