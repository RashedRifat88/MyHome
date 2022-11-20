package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;

import java.util.List;

@Dao
public interface DivisionDistrictThanaDao {

    @Query("select * from table_division_district_thana")
    LiveData<List<DivisionDistrictThana>> getAllDivisionDistrictThana();

    @Query("select * from table_division_district_thana order by id desc")
    LiveData<List<DivisionDistrictThana>> getDivisionDistrictThanaHighToLow();

    @Query("select * from table_division_district_thana order by id asc")
    LiveData<List<DivisionDistrictThana>> getDivisionDistrictThanaLowToHigh();

    @Insert
    void insertDivisionDistrictThana(DivisionDistrictThana... DivisionDistrictThanas);

    @Query("delete from table_division_district_thana where id = :id")
    void deleteDivisionDistrictThana(int id);

    @Update
    void updateDivisionDistrictThana(DivisionDistrictThana DivisionDistrictThana);

//    @Query("SELECT DISTINCT * FROM table_division_district_thana WHERE task_type = :type")
//    LiveData<List<DivisionDistrictThana>> getTypeWiseTaskList(String type);

}
