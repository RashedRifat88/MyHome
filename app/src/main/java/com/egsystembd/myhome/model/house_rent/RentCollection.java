package com.egsystembd.myhome.model.house_rent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_rent_collection")
public class RentCollection {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "rent_id")
    public int rent_id;

    @ColumnInfo(name = "paid_amount")
    public int paid_amount;

    @ColumnInfo(name = "nid")
    public String nid;

    @ColumnInfo(name = "created_at")
    public String created_at;

    @ColumnInfo(name = "updated_at")
    public String updated_at;


}
