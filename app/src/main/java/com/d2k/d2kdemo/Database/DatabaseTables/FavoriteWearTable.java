package com.d2k.d2kdemo.Database.DatabaseTables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FavoriteWearTable {
    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "favWearImageID")
    private  String favWearImageID;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFavWearImageID() {
        return favWearImageID;
    }

    public void setFavWearImageID(String favWearImageID) {
        this.favWearImageID = favWearImageID;
    }
}
