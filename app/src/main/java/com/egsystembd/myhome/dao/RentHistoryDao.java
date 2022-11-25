package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.Deed;

import java.util.List;

@Dao
public interface RentHistoryDao {

    @Query("select * from table_deed")
    LiveData<List<Deed>> getAllDeed();

    @Query("select * from table_deed order by id desc")
    LiveData<List<Deed>> getDeedHighToLow();

    @Query("select * from table_deed order by id asc")
    LiveData<List<Deed>> getDeedLowToHigh();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDeed(Deed... Deeds);

    @Query("delete from table_deed where id = :id")
    void deleteDeed(int id);

//    @Query("delete from table_deed")
//    void deleteAllDeed();

    @Update
    void updateDeed(Deed Deed);

//    @Query("SELECT DISTINCT * FROM table_deed WHERE task_type = :type")
//    LiveData<List<Deed>> getTypeWiseTaskList(String type);

    @Query("SELECT * FROM table_deed WHERE tenant_id = :id")
    Deed getSpecificDeed(int id);

}
