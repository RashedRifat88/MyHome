package com.egsystembd.myhome.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.RentCollectionDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.house_rent.RentCollection;

import java.util.List;

public class RentCollectionRepository {

    public RentCollectionDao RentCollectionDao;
    public LiveData<List<RentCollection>> getAllRentCollection;

    public LiveData<List<RentCollection>> getLowToHighRentCollection;
    public LiveData<List<RentCollection>> getHighToLowRentCollection;



    public RentCollectionRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        RentCollectionDao = database.RentCollectionDao();
        getAllRentCollection = RentCollectionDao.getAllRentCollection();

        getHighToLowRentCollection = RentCollectionDao.getRentCollectionHighToLow();
        getLowToHighRentCollection = RentCollectionDao.getRentCollectionLowToHigh();
    }

    public void insertRentCollection(RentCollection RentCollections) {
        RentCollectionDao.insertRentCollection(RentCollections);
    }

    public void deleteRentCollection(int id) {
        RentCollectionDao.deleteRentCollection(id);
    }

//    public void deleteAllRentCollection() {
//        RentCollectionDao.deleteAllRentCollection();
//    }

    public void updateRentCollection(RentCollection RentCollections) {
        RentCollectionDao.updateRentCollection(RentCollections);
    }

//    public LiveData<List<RentCollection>> getDivisionList() {
//        return RentCollectionDao.getDivisionList();
//    }
//
//
//    public List<RentCollection> getDistrictList(String division) {
//        return RentCollectionDao.getDistrictList(division);
//    }
//
//
//    public List<RentCollection> getThanaList(String district) {
//        return RentCollectionDao.getThanaList(district);
//    }



//    public LiveData<List<RentCollection>> getTypeWiseTaskList(String type) {
//        return RentCollectionDao.getTypeWiseTaskList(type);
//    }


    public RentCollection getSpecificRentCollection(int id) {
        return RentCollectionDao.getSpecificRentCollection(id);
    }

    public RentCollection getSpecificRentCollection(int deedId, int year, int monthId) {
        return RentCollectionDao.getSpecificRentCollection(deedId, year, monthId);
    }



}
