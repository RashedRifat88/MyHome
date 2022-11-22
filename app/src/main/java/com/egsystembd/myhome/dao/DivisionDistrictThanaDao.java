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

    @Query("delete from table_division_district_thana")
    void deleteAllDivisionDistrictThana();

    @Update
    void updateDivisionDistrictThana(DivisionDistrictThana DivisionDistrictThana);

//    @Query("SELECT DISTINCT * FROM table_division_district_thana WHERE task_type = :type")
//    LiveData<List<DivisionDistrictThana>> getTypeWiseTaskList(String type);

    @Query("SELECT * FROM table_division_district_thana group by division")
    LiveData<List<DivisionDistrictThana>> getDivisionList();

    @Query("SELECT * FROM table_division_district_thana WHERE division_bn = :division group by district")
    List<DivisionDistrictThana> getDistrictList(String division);


    @Query("SELECT * FROM table_division_district_thana WHERE district_bn = :district group by thana")
    List<DivisionDistrictThana> getThanaList(String district);


}
