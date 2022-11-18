package com.egsystembd.myhome.model.house_rent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_building")

public class Building {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "user_id")
    public int user_id;

    @ColumnInfo(name = "building_name")
    public String building_name;

    @ColumnInfo(name = "tin")
    public String tin;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "lat")
    public double lat;

    @ColumnInfo(name = "lon")
    public double lon;
    
}
