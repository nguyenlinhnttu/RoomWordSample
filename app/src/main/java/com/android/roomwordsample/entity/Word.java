package com.android.roomwordsample.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by NguyenLinh on 28,September,2018
 * https://developer.android.com/training/data-storage/room/defining-data
 */
@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "word")
    private String mWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word(@NonNull String word) {this.mWord = word;}

    public String getWord(){return this.mWord;}
}