package com.egsystembd.myhome.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.house_rent.Tenant;
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

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    long[] insertTenant(Tenant... Tenants);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertTenant1(Tenant Tenants);

    @Query("delete from table_tenant where id = :id")
    void deleteTenant(int id);

    @Query("delete from table_tenant")
    void deleteAllTenant();

    @Update
    void updateTenant(Tenant Tenant);

//    @Query("SELECT DISTINCT * FROM table_tenant WHERE task_type = :type")
//    LiveData<List<Tenant>> getTypeWiseTaskList(String type);

//    @Query("SELECT * FROM table_tenant group by division")
//    LiveData<List<Tenant>> getDivisionList();
//
//    @Query("SELECT * FROM table_tenant WHERE division_bn = :division group by district")
//    List<Tenant> getDistrictList(String division);
//

//    @Query("SELECT * FROM table_tenant WHERE district_bn = :district group by thana")
//    List<Tenant> getThanaList(String district);

//    @Query("SELECT id FROM table_tenant WHERE Tenant = :tenant")
//    int getTenantId(Tenant tenant);

    @Query("SELECT * FROM table_tenant WHERE id = :id")
    Tenant getTenantById(int id);


}
