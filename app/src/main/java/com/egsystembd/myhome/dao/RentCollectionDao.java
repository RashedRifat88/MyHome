package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.RentCollection;
import com.egsystembd.myhome.model.house_rent.RentCollection;

import java.util.List;

@Dao
public interface RentCollectionDao {

    @Query("select * from table_rent_collection")
    LiveData<List<RentCollection>> getAllRentCollection();

    @Query("select * from table_rent_collection order by id desc")
    LiveData<List<RentCollection>> getRentCollectionHighToLow();

    @Query("select * from table_rent_collection order by id asc")
    LiveData<List<RentCollection>> getRentCollectionLowToHigh();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRentCollection(RentCollection... RentCollections);

    @Query("delete from table_rent_collection where id = :id")
    void deleteRentCollection(int id);

    @Update
    void updateRentCollection(RentCollection RentCollection);

//    @Query("SELECT DISTINCT * FROM table_rent_collection WHERE task_type = :type")
//    LiveData<List<RentCollection>> getTypeWiseTaskList(String type);

    @Query("SELECT * FROM table_rent_collection WHERE deed_id = :id")
    RentCollection getSpecificRentCollection(int id);


    @Query("SELECT * FROM table_rent_collection WHERE deed_id = :deedId AND year = :year AND month_id = :monthId")
    RentCollection getSpecificRentCollection(int deedId, int year, int monthId);



}
