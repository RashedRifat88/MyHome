package com.egsystembd.myhome.repository.daily_expense;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.daily_expense.ExpenseTypeDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.daily_expense.ExpenseType;

import java.util.List;

public class ExpenseTypeRepository {

    public ExpenseTypeDao ExpenseTypeDao;
    public LiveData<List<ExpenseType>> getAllExpenseType;

    public LiveData<List<ExpenseType>> getLowToHighExpenseType;
    public LiveData<List<ExpenseType>> getHighToLowExpenseType;



    public ExpenseTypeRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        ExpenseTypeDao = database.ExpenseTypeDao();
        getAllExpenseType = ExpenseTypeDao.getAllExpenseType();

        getHighToLowExpenseType = ExpenseTypeDao.getExpenseTypeHighToLow();
        getLowToHighExpenseType = ExpenseTypeDao.getExpenseTypeLowToHigh();
    }

    public void insertExpenseType(ExpenseType ExpenseTypes) {
        ExpenseTypeDao.insertExpenseType(ExpenseTypes);
    }

    public void deleteExpenseType(int id) {
        ExpenseTypeDao.deleteExpenseType(id);
    }

//    public void deleteAllExpenseType() {
//        ExpenseTypeDao.deleteAllExpenseType();
//    }

    public void updateExpenseType(ExpenseType ExpenseTypes) {
        ExpenseTypeDao.updateExpenseType(ExpenseTypes);
    }

//    public LiveData<List<ExpenseType>> getDivisionList() {
//        return ExpenseTypeDao.getDivisionList();
//    }
//
//
//    public List<ExpenseType> getDistrictList(String division) {
//        return ExpenseTypeDao.getDistrictList(division);
//    }
//
//
//    public List<ExpenseType> getThanaList(String district) {
//        return ExpenseTypeDao.getThanaList(district);
//    }



//    public LiveData<List<ExpenseType>> getTypeWiseTaskList(String type) {
//        return ExpenseTypeDao.getTypeWiseTaskList(type);
//    }


//    public ExpenseType getSpecificExpenseType(int id) {
//        return ExpenseTypeDao.getSpecificExpenseType(id);
//    }
//
//    public ExpenseType getExpenseTypeByTenantId(int id) {
//        return ExpenseTypeDao.getExpenseTypeByTenantId(id);
//    }
//


}
