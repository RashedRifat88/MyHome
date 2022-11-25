package com.egsystembd.myhome.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.RentDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.house_rent.Rent;

import java.util.List;

public class RentRepository {

    public RentDao RentDao;
    public LiveData<List<Rent>> getAllRent;

    public LiveData<List<Rent>> getLowToHighRent;
    public LiveData<List<Rent>> getHighToLowRent;



    public RentRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        RentDao = database.RentDao();
        getAllRent = RentDao.getAllRent();

        getHighToLowRent = RentDao.getRentHighToLow();
        getLowToHighRent = RentDao.getRentLowToHigh();
    }

    public long insertRent1(Rent rents) {
        return RentDao.insertRent1(rents);
    }

    public void deleteRent(int id) {
        RentDao.deleteRent(id);
    }

//    public void deleteAllRent() {
//        RentDao.deleteAllRent();
//    }

    public void updateRent(Rent Rents) {
        RentDao.updateRent(Rents);
    }

//    public LiveData<List<Rent>> getDivisionList() {
//        return RentDao.getDivisionList();
//    }
//
//
//    public List<Rent> getDistrictList(String division) {
//        return RentDao.getDistrictList(division);
//    }
//
//
//    public List<Rent> getThanaList(String district) {
//        return RentDao.getThanaList(district);
//    }



//    public LiveData<List<Rent>> getTypeWiseTaskList(String type) {
//        return RentDao.getTypeWiseTaskList(type);
//    }


//    public Rent getSpecificRent(int id) {
//        return RentDao.getSpecificRent(id);
//    }


}
