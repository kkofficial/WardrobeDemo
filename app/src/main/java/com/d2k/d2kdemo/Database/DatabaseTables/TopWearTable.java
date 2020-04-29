package com.d2k.d2kdemo.Database.DatabaseTables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TopWearTable {
    @PrimaryKey(autoGenerate = true)
    private int id;


  /*  @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;*/

  @ColumnInfo(name = "image")
  private String image;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
