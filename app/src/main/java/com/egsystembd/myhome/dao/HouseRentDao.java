package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.egsystembd.myhome.model.HouseRent;

import java.util.List;

@Dao
public interface HouseRentDao {

    @Query("select * from table_house_rent")
    LiveData<List<HouseRent>> getAllHouseRent();

    @Query("select * from table_house_rent order by HouseRent_priority desc")
    LiveData<List<HouseRent>> getHouseRentHighToLow();

    @Query("select * from table_house_rent order by HouseRent_priority asc")
    LiveData<List<HouseRent>> getHouseRentLowToHigh();

    @Insert
    void insertHouseRent(HouseRent... HouseRents);

    @Query("delete from table_house_rent where id = :id")
    void deleteHouseRent(int id);

    @Update
    void updateHouseRent(HouseRent HouseRent);

    @Query("SELECT DISTINCT * FROM table_house_rent WHERE task_type = :type")
    LiveData<List<HouseRent>> getTypeWiseTaskList (String type);

}
