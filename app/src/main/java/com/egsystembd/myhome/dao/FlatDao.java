package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.Flat;

import java.util.List;

@Dao
public interface FlatDao {

    @Query("select * from table_flat")
    LiveData<List<Flat>> getAllFlat();

    @Query("select * from table_flat order by id desc")
    LiveData<List<Flat>> getFlatHighToLow();

    @Query("select * from table_flat order by id asc")
    LiveData<List<Flat>> getFlatLowToHigh();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFlat(Flat... Flats);

    @Query("delete from table_flat where id = :id")
    void deleteFlat(int id);

    @Update
    void updateFlat(Flat Flat);

//    @Query("SELECT DISTINCT * FROM table_flat WHERE task_type = :type")
//    LiveData<List<Flat>> getTypeWiseTaskList(String type);

}
