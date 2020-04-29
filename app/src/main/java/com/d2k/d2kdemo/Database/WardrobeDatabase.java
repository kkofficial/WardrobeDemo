package com.d2k.d2kdemo.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.d2k.d2kdemo.Database.DatabaseTables.FavoriteWearTable;
import com.d2k.d2kdemo.Database.DatabaseTables.TopWearTable;
import com.d2k.d2kdemo.Database.DatabaseTables.TrouserWeartable;

@Database(entities = {TopWearTable.class , TrouserWeartable.class, FavoriteWearTable.class}, version = 1)
public abstract class WardrobeDatabase extends RoomDatabase {
    public  abstract DataAccessClass dataAccessClass();
}
