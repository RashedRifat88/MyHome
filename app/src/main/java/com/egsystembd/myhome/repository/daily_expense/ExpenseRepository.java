package com.egsystembd.myhome.repository.daily_expense;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.daily_expense.ExpenseDao;

import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.daily_expense.Expense;


import java.util.List;

public class ExpenseRepository {

    public ExpenseDao ExpenseDao;
    public LiveData<List<Expense>> getAllExpense;

    public LiveData<List<Expense>> getLowToHighExpense;
    public LiveData<List<Expense>> getHighToLowExpense;



    public ExpenseRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        ExpenseDao = database.ExpenseDao();
        getAllExpense = ExpenseDao.getAllExpense();

        getHighToLowExpense = ExpenseDao.getExpenseHighToLow();
        getLowToHighExpense = ExpenseDao.getExpenseLowToHigh();
    }

    public void insertExpense(Expense Expenses) {
        ExpenseDao.insertExpense(Expenses);
    }

    public void deleteExpense(int id) {
        ExpenseDao.deleteExpense(id);
    }

//    public void deleteAllExpense() {
//        ExpenseDao.deleteAllExpense();
//    }

    public void updateExpense(Expense Expenses) {
        ExpenseDao.updateExpense(Expenses);
    }

//    public LiveData<List<Expense>> getDivisionList() {
//        return ExpenseDao.getDivisionList();
//    }
//
//
//    public List<Expense> getDistrictList(String division) {
//        return ExpenseDao.getDistrictList(division);
//    }
//
//
//    public List<Expense> getThanaList(String district) {
//        return ExpenseDao.getThanaList(district);
//    }



//    public LiveData<List<Expense>> getTypeWiseTaskList(String type) {
//        return ExpenseDao.getTypeWiseTaskList(type);
//    }


//    public Expense getSpecificExpense(int id) {
//        return ExpenseDao.getSpecificExpense(id);
//    }
//
//    public Expense getExpenseByTenantId(int id) {
//        return ExpenseDao.getExpenseByTenantId(id);
//    }
//


}
