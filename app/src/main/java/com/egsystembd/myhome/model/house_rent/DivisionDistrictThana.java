package com.egsystembd.myhome.model.house_rent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_division_district_thana")
public class DivisionDistrictThana {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "division")
    public String division;

    @ColumnInfo(name = "division_bn")
    public String division_bn;


    @ColumnInfo(name = "district")
    public String district;

    @ColumnInfo(name = "district_bn")
    public String district_bn;


    @ColumnInfo(name = "thana")
    public String thana;

    @ColumnInfo(name = "thana_bn")
    public String thana_bn;



}
