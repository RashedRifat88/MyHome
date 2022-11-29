package com.egsystembd.myhome.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.TenantDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.house_rent.Tenant;

import java.util.List;

public class TenantRepository {

    public TenantDao TenantDao;
    public LiveData<List<Tenant>> getAllTenant;

    public LiveData<List<Tenant>> getLowToHighTenant;
    public LiveData<List<Tenant>> getHighToLowTenant;



    public TenantRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        TenantDao = database.TenantDao();
        getAllTenant = TenantDao.getAllTenant();

        getHighToLowTenant = TenantDao.getTenantHighToLow();
        getLowToHighTenant = TenantDao.getTenantLowToHigh();
    }

    public long insertTenant1(Tenant Tenants) {
         return TenantDao.insertTenant1(Tenants);
    }

    public void deleteTenant(int id) {
        TenantDao.deleteTenant(id);
    }

    public void deleteAllTenant() {
        TenantDao.deleteAllTenant();
    }

    public void updateTenant(Tenant Tenants) {
        TenantDao.updateTenant(Tenants);
    }

//    public LiveData<List<Tenant>> getDivisionList() {
//        return TenantDao.getDivisionList();
//    }
//
//
//    public List<Tenant> getDistrictList(String division) {
//        return TenantDao.getDistrictList(division);
//    }
//
//
//    public List<Tenant> getThanaList(String district) {
//        return TenantDao.getThanaList(district);
//    }



//    public LiveData<List<Tenant>> getTypeWiseTaskList(String type) {
//        return TenantDao.getTypeWiseTaskList(type);
//    }


//    public int getTenantId(Tenant tenant) {
//        return TenantDao.getTenantId(tenant);
//    }

    public Tenant getTenantById(int id) {
        return TenantDao.getTenantById(id);
    }



}
