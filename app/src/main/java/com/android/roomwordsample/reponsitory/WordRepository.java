package com.android.roomwordsample.reponsitory;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.android.roomwordsample.dao.WordDao;
import com.android.roomwordsample.entity.Word;
import com.android.roomwordsample.room.WordRoomDatabase;

import java.util.List;

/**
 * Created by NguyenLinh on 28,September,2018
 * https://developer.android.com/jetpack/docs/guide // Check here
 */
public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public  WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}


