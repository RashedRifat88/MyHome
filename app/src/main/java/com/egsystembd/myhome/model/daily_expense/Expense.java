package com.egsystembd.myhome.model.daily_expense;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_expense")
public class Expense {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "user_id")
    public int user_id;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "month")
    public String month;

    @ColumnInfo(name = "year")
    public String year;

    @ColumnInfo(name = "expense_name")
    public String expense_name;

    @ColumnInfo(name = "amount")
    public String amount;


}
