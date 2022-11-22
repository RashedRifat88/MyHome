package com.egsystembd.myhome.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.DivisionDistrictThanaDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;


import java.util.List;

public class DivisionDistrictThanaRepository {

    public DivisionDistrictThanaDao DivisionDistrictThanaDao;
    public LiveData<List<DivisionDistrictThana>> getAllDivisionDistrictThana;

    public LiveData<List<DivisionDistrictThana>> getLowToHighDivisionDistrictThana;
    public LiveData<List<DivisionDistrictThana>> getHighToLowDivisionDistrictThana;



    public DivisionDistrictThanaRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        DivisionDistrictThanaDao = database.divisionDistrictThanaDao();
        getAllDivisionDistrictThana = DivisionDistrictThanaDao.getAllDivisionDistrictThana();

        getHighToLowDivisionDistrictThana = DivisionDistrictThanaDao.getDivisionDistrictThanaHighToLow();
        getLowToHighDivisionDistrictThana = DivisionDistrictThanaDao.getDivisionDistrictThanaLowToHigh();
    }

    public void insertDivisionDistrictThana(DivisionDistrictThana DivisionDistrictThanas) {
        DivisionDistrictThanaDao.insertDivisionDistrictThana(DivisionDistrictThanas);
    }

    public void deleteDivisionDistrictThana(int id) {
        DivisionDistrictThanaDao.deleteDivisionDistrictThana(id);
    }

    public void deleteAllDivisionDistrictThana() {
        DivisionDistrictThanaDao.deleteAllDivisionDistrictThana();
    }

    public void updateDivisionDistrictThana(DivisionDistrictThana DivisionDistrictThanas) {
        DivisionDistrictThanaDao.updateDivisionDistrictThana(DivisionDistrictThanas);
    }

    public LiveData<List<DivisionDistrictThana>> getDivisionList() {
        return DivisionDistrictThanaDao.getDivisionList();
    }


    public List<DivisionDistrictThana> getDistrictList(String division) {
        return DivisionDistrictThanaDao.getDistrictList(division);
    }


    public List<DivisionDistrictThana> getThanaList(String district) {
        return DivisionDistrictThanaDao.getThanaList(district);
    }


//
//    public LiveData<List<DivisionDistrictThana>> getTypeWiseTaskList(String type) {
//        return DivisionDistrictThanaDao.getTypeWiseTaskList(type);
//    }


}
