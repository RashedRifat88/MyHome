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

//    @ColumnInfo(name = "paid_amount")
//    public int paid_amount;

    @ColumnInfo(name = "tenant_id")
    public int tenant_id;

    @ColumnInfo(name = "deed_id")
    public int deed_id;

    @ColumnInfo(name = "year")
    public int year;

    @ColumnInfo(name = "month_id")
    public int month_id;

    @ColumnInfo(name = "total_payable_rent")
    public float total_payable_rent;

    @ColumnInfo(name = "total_collect")
    public float total_collect;

    @ColumnInfo(name = "remaining_amount")
    public float remaining_amount;

    @ColumnInfo(name = "created_at")
    public String created_at;

    @ColumnInfo(name = "updated_at")
    public String updated_at;


}
