package com.egsystembd.myhome.model.house_rent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_rent")

public class Rent {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "deed_id")
    public int deed_id;

    @ColumnInfo(name = "year")
    public int year;

    @ColumnInfo(name = "month_id")
    public int month_id;

    @ColumnInfo(name = "rent_amount")
    public int rent_amount;

    @ColumnInfo(name = "service_charge")
    public float service_charge;

    @ColumnInfo(name = "electricity")
    public float electricity;

    @ColumnInfo(name = "gas")
    public float gas;

    @ColumnInfo(name = "water")
    public float water;

    @ColumnInfo(name = "security")
    public float security;

    @ColumnInfo(name = "cleaning")
    public float cleaning;

    @ColumnInfo(name = "garage")
    public float garage;

    @ColumnInfo(name = "common")
    public float common;

    @ColumnInfo(name = "others")
    public float others;


}
