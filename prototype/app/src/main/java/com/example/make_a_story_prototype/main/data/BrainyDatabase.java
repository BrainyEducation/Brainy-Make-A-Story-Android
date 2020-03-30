package com.example.make_a_story_prototype.main.data;

import android.content.Context;
import android.os.AsyncTask;

import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryBlankIdentifier;
import com.example.make_a_story_prototype.main.StoryTemplate.model.StoryText;

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
            new PopulateDatabaseAsyncTask(instance).execute();
        }
    };

    private static class PopulateDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {
        private TextSegmentDao textSegmentDao;
        private BlankDao blankDao;

        private PopulateDatabaseAsyncTask(BrainyDatabase db) {
            textSegmentDao = db.textSegmentDao();
            blankDao = db.blankDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            textSegmentDao.insert(new TextSegment("The Space Alien", 1,"One Saturday evening "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1," and "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1," made a tent to camp out in the back "
                   + "yard.  They griped and whined and complained to each other about a school "
                   + "assignment due next week:  to stand in front of the whole class and show "
                   + "pictures and talk about a special place they had visited.  Neither one had "
                   + "any special pictures of any place special, and they both just knew the "
                   + "teacher would embarrass them, and the other kids would tease them, and Monday "
                   + "would be terrifishously, awfulishously, horrifishously bad.  "
                   + "Feeling glum, "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1," snuggled tight in some blankets and "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1," curled up in a sleeping bag, when about "
                   + "midnight a strange-shaped shadow flickered on their tent wall.  \n"
                   + "\t\"What’s that” asked "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1,".   \"Maybe some "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1,".\""));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1,"\" Or a maybe some kind of \""));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1,",\" guessed "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 1," They stuck their noses outside to find a "
                    + "weird looking space alien just their size."));

            textSegmentDao.insert(new TextSegment("The Space Alien", 2,"\"Please help me!\" \n"
                    + "\t\"How?\" \t\n"
                    + "\t\"For my school project I need pictures of earth stuff, and I took a few pictures but I need more.\"\n"
                    + "\t\"Show us.\" \n"
                    + "\tSpace Alien punched a shiny elbow button and twisted a fancy shoulder dial, and Space Alien’s tummy screen displayed a glowy"));
            textSegmentDao.insert(new TextSegment("The Space Alien", 2," and "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 2,"\"That’s a strange looking earth planet"));
            textSegmentDao.insert(new TextSegment("The Space Alien", 2,"\"Nope.  Actually, a pretty nice"));
            textSegmentDao.insert(new TextSegment("The Space Alien", 2,"\"No!  Are you sure?\" \n"
                    + "\tBoth kids nodded yes. \"But my sister said— I just feel so "));
            textSegmentDao.insert(new TextSegment("The Space Alien", 2,".  It makes me want to"));
            textSegmentDao.insert(new TextSegment("The Space Alien", 2,".\""));


            return null;
        }
    }
}
