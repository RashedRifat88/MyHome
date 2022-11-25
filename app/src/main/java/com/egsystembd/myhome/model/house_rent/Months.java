package com.egsystembd.myhome.model.house_rent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_months")
public class Months {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "month_id")
    public int month_id;

    @ColumnInfo(name = "month_name")
    public String month_name;

    @ColumnInfo(name = "month_name_bn")
    public String month_name_bn;


}
