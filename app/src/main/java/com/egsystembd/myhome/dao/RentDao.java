package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.Rent;
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

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertRent(Rent... Rents);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertRent1(Rent Rents);

    @Query("delete from table_rent where id = :id")
    void deleteRent(int id);

    @Update
    void updateRent(Rent Rent);

//    @Query("SELECT DISTINCT * FROM table_rent WHERE task_type = :type")
//    LiveData<List<Rent>> getTypeWiseTaskList(String type);

//    @Query("SELECT * FROM table_rent WHERE tenant_id = :id")
//    Rent getSpecificRent(int id);

    @Query("SELECT * FROM table_rent WHERE deed_id = :id AND year= :year AND deed_id= :deedId")
    Rent getSpecificRent(int id, int year, int deedId);


}
