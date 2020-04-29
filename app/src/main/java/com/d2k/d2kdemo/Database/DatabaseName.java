package com.d2k.d2kdemo.Database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseName {

    private Context mCtx;
    private static DatabaseName mInstance;

    //our app database object
    private WardrobeDatabase wardrobeDatabase;

    private DatabaseName(Context mCtx) {
        this.mCtx = mCtx;

        wardrobeDatabase = Room.databaseBuilder(mCtx, WardrobeDatabase.class, "MyWardrobeData").build();
    }

    public static synchronized DatabaseName getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseName(mCtx);
        }
        return mInstance;
    }

    public WardrobeDatabase getWardrobeDatabase() {
        return wardrobeDatabase;
    }
}