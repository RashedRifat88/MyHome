package com.egsystembd.myhome.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.DeedDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.house_rent.Deed;

import java.util.List;

public class DeedRepository {

    public DeedDao DeedDao;
    public LiveData<List<Deed>> getAllDeed;

    public LiveData<List<Deed>> getLowToHighDeed;
    public LiveData<List<Deed>> getHighToLowDeed;



    public DeedRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        DeedDao = database.DeedDao();
        getAllDeed = DeedDao.getAllDeed();

        getHighToLowDeed = DeedDao.getDeedHighToLow();
        getLowToHighDeed = DeedDao.getDeedLowToHigh();
    }

    public void insertDeed(Deed Deeds) {
        DeedDao.insertDeed(Deeds);
    }

    public void deleteDeed(int id) {
        DeedDao.deleteDeed(id);
    }

//    public void deleteAllDeed() {
//        DeedDao.deleteAllDeed();
//    }

    public void updateDeed(Deed Deeds) {
        DeedDao.updateDeed(Deeds);
    }

//    public LiveData<List<Deed>> getDivisionList() {
//        return DeedDao.getDivisionList();
//    }
//
//
//    public List<Deed> getDistrictList(String division) {
//        return DeedDao.getDistrictList(division);
//    }
//
//
//    public List<Deed> getThanaList(String district) {
//        return DeedDao.getThanaList(district);
//    }



//    public LiveData<List<Deed>> getTypeWiseTaskList(String type) {
//        return DeedDao.getTypeWiseTaskList(type);
//    }


    public Deed getSpecificDeed(int id) {
        return DeedDao.getSpecificDeed(id);
    }

    public Deed getDeedByTenantId(int id) {
        return DeedDao.getDeedByTenantId(id);
    }



}
