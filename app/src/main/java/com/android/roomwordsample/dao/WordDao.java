package com.android.roomwordsample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.android.roomwordsample.entity.Word;

import java.util.List;

/**
 * Created by NguyenLinh on 28,September,2018
 * https://developer.android.com/training/data-storage/room/accessing-data
 */
@Dao
public interface WordDao {
    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

}
