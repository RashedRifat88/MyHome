package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.Months;

import java.util.List;

@Dao
public interface MonthsDao {

    @Query("select * from table_months")
    LiveData<List<Months>> getAllMonth();

    @Query("select * from table_months order by id desc")
    LiveData<List<Months>> getMonthHighToLow();

    @Query("select * from table_months order by id asc")
    LiveData<List<Months>> getMonthLowToHigh();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMonths(Months... Months);

    @Query("delete from table_months where id = :id")
    void deleteMonths(int id);

    @Query("delete from table_months")
    void deleteAllMonth();

    @Update
    void updateMonth(Months Month);

//    @Query("SELECT DISTINCT * FROM table_months WHERE task_type = :type")
//    LiveData<List<Month>> getTypeWiseTaskList(String type);

//    @Query("SELECT * FROM table_months group by division")
//    LiveData<List<Month>> getDivisionList();
//
//    @Query("SELECT * FROM table_months WHERE division_bn = :division group by district")
//    List<Month> getDistrictList(String division);
//
//
//    @Query("SELECT * FROM table_months WHERE district_bn = :district group by thana")
//    List<Month> getThanaList(String district);


}
