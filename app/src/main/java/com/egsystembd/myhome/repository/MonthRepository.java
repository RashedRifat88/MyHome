package com.egsystembd.myhome.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.MonthsDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.house_rent.Months;

import java.util.List;

public class MonthRepository {

    public MonthsDao MonthsDao;
    public LiveData<List<Months>> getAllMonth;

    public LiveData<List<Months>> getLowToHighMonth;
    public LiveData<List<Months>> getHighToLowMonth;



    public MonthRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        MonthsDao = (com.egsystembd.myhome.dao.MonthsDao) database.MonthsDao();
        getAllMonth = MonthsDao.getAllMonth();

        getHighToLowMonth = MonthsDao.getMonthHighToLow();
        getLowToHighMonth = MonthsDao.getMonthLowToHigh();
    }

    public void insertMonth(Months Months) {
        MonthsDao.insertMonths(Months);
    }

    public void deleteMonth(int id) {
        MonthsDao.deleteMonths(id);
    }

    public void deleteAllMonth() {
        MonthsDao.deleteAllMonth();
    }

    public void updateMonth(Months Months) {
        MonthsDao.updateMonth(Months);
    }

//    public LiveData<List<Month>> getDivisionList() {
//        return MonthDao.getDivisionList();
//    }
//
//
//    public List<Month> getDistrictList(String division) {
//        return MonthDao.getDistrictList(division);
//    }
//
//
//    public List<Month> getThanaList(String district) {
//        return MonthDao.getThanaList(district);
//    }


//
//    public LiveData<List<Month>> getTypeWiseTaskList(String type) {
//        return MonthDao.getTypeWiseTaskList(type);
//    }


}
