package com.egsystembd.myhome.model.house_rent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_flat")
public class Flat {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "building_id")
    public int building_id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "details")
    public String details;

    @ColumnInfo(name = "monthly_rent")
    public float monthly_rent;

    @ColumnInfo(name = "service_charge")
    public float service_charge;

}
