package com.egsystembd.myhome.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_house_rent")
public class HouseRent {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "HouseRent_title")
    public String HouseRentTitle;

    @ColumnInfo(name = "HouseRent_sub_title")
    public String HouseRentSubTitle;

    @ColumnInfo(name = "HouseRent_details")
    public String HouseRentDetails;

    @ColumnInfo(name = "HouseRent_date")
    public String HouseRentDate;

    @ColumnInfo(name = "HouseRent_priority")
    public String HouseRentPriority;

    @ColumnInfo(name = "task_completion_status")
    public String taskCompletionStatus;

    @ColumnInfo(name = "task_start_date_time")
    public String taskStartDateTime;

    @ColumnInfo(name = "task_end_targeted_date")
    public String taskEndTargetedDate;

    @ColumnInfo(name = "task_end_date_time")
    public String taskEndtDateTime;

    @ColumnInfo(name = "task_type")
    public String taskType;

    @ColumnInfo(name = "firstAlarmTime")
    public String firstAlarmTime;

    @ColumnInfo(name = "secondAlarmTime")
    public String secondAlarmTime;

    @ColumnInfo(name = "lastAlarm")
    public String lastAlarm;


}
