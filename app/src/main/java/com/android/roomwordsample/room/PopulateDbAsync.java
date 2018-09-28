package com.android.roomwordsample.room;

import android.os.AsyncTask;

import com.android.roomwordsample.dao.WordDao;
import com.android.roomwordsample.entity.Word;

/**
 * Created by NguyenLinh on 28,September,2018
 */
public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final WordDao mDao;

    PopulateDbAsync(WordRoomDatabase db) {
        mDao = db.wordDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();
        Word word = new Word("Hello");
        mDao.insert(word);
        word = new Word("World");
        mDao.insert(word);
        return null;
    }
}