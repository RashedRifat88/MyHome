package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.Tenant;

import java.util.List;

@Dao
public interface TenantDao {

    @Query("select * from table_tenant")
    LiveData<List<Tenant>> getAllTenant();

    @Query("select * from table_tenant order by id desc")
    LiveData<List<Tenant>> getTenantHighToLow();

    @Query("select * from table_tenant order by id asc")
    LiveData<List<Tenant>> getTenantLowToHigh();

    @Insert
    void insertTenant(Tenant... Tenants);

    @Query("delete from table_tenant where id = :id")
    void deleteTenant(int id);

    @Update
    void updateTenant(Tenant Tenant);

//    @Query("SELECT DISTINCT * FROM table_tenant WHERE task_type = :type")
//    LiveData<List<Tenant>> getTypeWiseTaskList(String type);

}
