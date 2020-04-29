package com.d2k.d2kdemo.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.d2k.d2kdemo.Database.DatabaseTables.FavoriteWearTable;
import com.d2k.d2kdemo.Database.DatabaseTables.TopWearTable;
import com.d2k.d2kdemo.Database.DatabaseTables.TrouserWeartable;

import java.util.List;

@Dao
public interface DataAccessClass {

    @Insert
    void insert(TopWearTable roomRecord);

    @Query("SELECT *  FROM TopWearTable")
    List<TopWearTable> getAllTopWearData();

    @Insert
    void insert(TrouserWeartable trouserWeartable);

    @Query("SELECT * FROM TrouserWeartable")
    List<TrouserWeartable> getAllTrouserWearData();

    @Query("SELECT * FROM TrouserWeartable ORDER BY random() ")
    List<TrouserWeartable> getRandomTrouserWearData();

     @Query("SELECT * FROM TopWearTable ORDER BY random() ")
    List<TopWearTable> getRandomTopWearData();

    @Insert
    void insert(FavoriteWearTable favoriteWearTable);

    @Query("SELECT * FROM FavoriteWearTable")
    List<FavoriteWearTable> getFavData();
}
