package com.example.make_a_story_prototype.main.data;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;


public class TextSegmentRepository {
    private TextSegmentDao textSegmentDao;
    private List<TextSegment> allTextSegments;

    public TextSegmentRepository(Application application) {
        BrainyDatabase database = BrainyDatabase.getInstance(application);
        textSegmentDao = database.textSegmentDao();
        allTextSegments = textSegmentDao.getAllTextSegments();
    }

    public void insert(TextSegment textSegment) {
        new InsertTextSegmentAsyncTask(textSegmentDao).execute(textSegment);
    }

    public List<TextSegment> getAllTextSegments() {
       return allTextSegments;
    }

    private static class InsertTextSegmentAsyncTask extends AsyncTask<TextSegment, Void, Void> {
        private TextSegmentDao textSegmentDao;

        private InsertTextSegmentAsyncTask(TextSegmentDao textSegmentDao) {
            this.textSegmentDao = textSegmentDao;
        }

        @Override
        protected Void doInBackground(TextSegment... textSegments) {
            textSegmentDao.insert(textSegments[0]);
            return null;
        }
    }

}
