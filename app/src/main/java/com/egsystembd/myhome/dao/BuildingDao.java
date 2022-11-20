package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.Building;

import java.util.List;

@Dao
public interface BuildingDao {

    @Query("select * from table_building")
    LiveData<List<Building>> getAllBuilding();

    @Query("select * from table_building order by id desc")
    LiveData<List<Building>> getBuildingHighToLow();

    @Query("select * from table_building order by id asc")
    LiveData<List<Building>> getBuildingLowToHigh();

    @Insert
    void insertBuilding(Building... Buildings);

    @Query("delete from table_building where id = :id")
    void deleteBuilding(int id);

    @Update
    void updateBuilding(Building Building);

//    @Query("SELECT DISTINCT * FROM table_building WHERE task_type = :type")
//    LiveData<List<Building>> getTypeWiseTaskList(String type);

}
