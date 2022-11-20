package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.Rent;

import java.util.List;

@Dao
public interface RentDao {

    @Query("select * from table_rent")
    LiveData<List<Rent>> getAllRent();

    @Query("select * from table_rent order by id desc")
    LiveData<List<Rent>> getRentHighToLow();

    @Query("select * from table_rent order by id asc")
    LiveData<List<Rent>> getRentLowToHigh();

    @Insert
    void insertRent(Rent... Rents);

    @Query("delete from table_rent where id = :id")
    void deleteRent(int id);

    @Update
    void updateRent(Rent Rent);

//    @Query("SELECT DISTINCT * FROM table_rent WHERE task_type = :type")
//    LiveData<List<Rent>> getTypeWiseTaskList(String type);

}
