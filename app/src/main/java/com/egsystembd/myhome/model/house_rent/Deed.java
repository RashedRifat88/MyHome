package com.egsystembd.myhome.model.house_rent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "table_deed")
public class Deed {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "tenant_id")
    public int tenant_id;

    @ColumnInfo(name = "flat_id")
    public int flat_id;

    @ColumnInfo(name = "contract_start")
    public String contract_start;

    @ColumnInfo(name = "monthly_rent")
    public float monthly_rent;

    @ColumnInfo(name = "service_charge")
    public float service_charge;

    @ColumnInfo(name = "total_advance")
    public float total_advance;

    @ColumnInfo(name = "advance_adjustment")
    public float advance_adjustment;

    @ColumnInfo(name = "duration")
    public float duration;

    @ColumnInfo(name = "note")
    public String note;

    @ColumnInfo(name = "validity")
    public boolean validity;


}
