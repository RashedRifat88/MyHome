package com.egsystembd.myhome.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.HouseRentDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.HouseRent;

import java.util.List;

public class HouseRentRepository {

    public HouseRentDao HouseRentDao;
    public LiveData<List<HouseRent>> getAllHouseRent;

    public LiveData<List<HouseRent>> getLowToHighHouseRent;
    public LiveData<List<HouseRent>> getHighToLowHouseRent;



    public HouseRentRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        HouseRentDao = database.HouseRentDao();
        getAllHouseRent = HouseRentDao.getAllHouseRent();

        getHighToLowHouseRent = HouseRentDao.getHouseRentHighToLow();
        getLowToHighHouseRent = HouseRentDao.getHouseRentLowToHigh();
    }

    public void insertHouseRent(HouseRent HouseRents) {
        HouseRentDao.insertHouseRent(HouseRents);
    }

    public void deleteHouseRent(int id) {
        HouseRentDao.deleteHouseRent(id);
    }

    public void updateHouseRent(HouseRent HouseRents) {
        HouseRentDao.updateHouseRent(HouseRents);
    }

    public LiveData<List<HouseRent>> getTypeWiseTaskList(String type) {
        return HouseRentDao.getTypeWiseTaskList(type);
    }


}
