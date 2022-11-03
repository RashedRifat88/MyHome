package com.egsystembd.myhome.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_task_type")
public class TaskType {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "task_type_name")
    public String task_type_name;

//    @ColumnInfo(name = "update_date")
//    public String update_date;


}
