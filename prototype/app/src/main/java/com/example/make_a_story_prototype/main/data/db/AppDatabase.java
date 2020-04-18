package com.example.make_a_story_prototype.main.data.db;

import android.content.Context;

import com.example.make_a_story_prototype.main.data.db.entity.Character;
import com.example.make_a_story_prototype.main.data.db.dao.CharacterDao;
import com.example.make_a_story_prototype.main.data.db.entity.CharacterImage;
import com.example.make_a_story_prototype.main.data.db.dao.CharacterImageDao;
import com.example.make_a_story_prototype.main.data.db.entity.CharacterName;
import com.example.make_a_story_prototype.main.data.db.dao.CharacterNameDao;
import com.example.make_a_story_prototype.main.data.db.entity.Blank;
import com.example.make_a_story_prototype.main.data.db.dao.BlankDao;
import com.example.make_a_story_prototype.main.data.db.entity.Story;
import com.example.make_a_story_prototype.main.data.db.dao.StoryDao;
import com.example.make_a_story_prototype.main.data.db.entity.StoryPage;
import com.example.make_a_story_prototype.main.data.db.dao.StoryPageDao;
import com.example.make_a_story_prototype.main.data.db.entity.TextSegment;
import com.example.make_a_story_prototype.main.data.db.dao.TextSegmentDao;
import com.example.make_a_story_prototype.main.data.db.entity.Category;
import com.example.make_a_story_prototype.main.data.db.dao.CategoryDao;
import com.example.make_a_story_prototype.main.data.db.entity.Word;
import com.example.make_a_story_prototype.main.data.db.dao.WordDao;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {
        Character.class,
        CharacterImage.class,
        CharacterName.class,
        Blank.class,
        Story.class,
        StoryPage.class,
        TextSegment.class,
        Category.class,
        Word.class
        }, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();
    public abstract CharacterImageDao characterImageDao();
    public abstract CharacterNameDao characterNameDao();
    public abstract BlankDao blankDao();
    public abstract StoryDao storyDao();
    public abstract StoryPageDao storyPageDao();
    public abstract TextSegmentDao textSegmentDao();
    public abstract CategoryDao categoryDao();
    public abstract WordDao wordDao();

    private static AppDatabase appDatabase;

    static synchronized AppDatabase getAppDatabase(final Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app-database").build();
        }
        return appDatabase;
    }
}
