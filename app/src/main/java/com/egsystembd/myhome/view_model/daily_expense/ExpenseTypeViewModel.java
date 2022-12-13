package com.egsystembd.myhome.view_model.daily_expense;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.egsystembd.myhome.model.daily_expense.ExpenseType;
import com.egsystembd.myhome.repository.daily_expense.ExpenseTypeRepository;

import java.util.List;

public class ExpenseTypeViewModel extends AndroidViewModel {

    ExpenseTypeRepository repository;
    public LiveData<List<ExpenseType>> getAllExpenseType;

    public LiveData<List<ExpenseType>> getLowToHighExpenseType;
    public LiveData<List<ExpenseType>> getHighToLowExpenseType;

    public ExpenseTypeViewModel(Application application) {
        super(application);

        repository = new ExpenseTypeRepository(application);
        getAllExpenseType = repository.getAllExpenseType;

        getHighToLowExpenseType = repository.getHighToLowExpenseType;
        getLowToHighExpenseType = repository.getLowToHighExpenseType;
    }

    public void insertExpenseType(ExpenseType notes) {
        repository.insertExpenseType(notes);
    }

    public void deleteExpenseType(int id) {
        repository.deleteExpenseType(id);
    }

    public void updateExpenseType(ExpenseType notes) {
        repository.updateExpenseType(notes);
    }

//    public void deleteAllExpenseType() {
//        repository.deleteAllExpenseType();
//    }
//
//    public LiveData<List<ExpenseType>> getDivisionList() {
//        return repository.getDivisionList();
//    }
//
//    public List<ExpenseType> getDistrictList(String division) {
//        return repository.getDistrictList(division);
//    }
//
//    public List<ExpenseType> getThanaList(String district) {
//        return repository.getThanaList(district);
//    }

//    public LiveData<List<ExpenseType>> getTypeWiseTaskList(String type) {
//        return repository.getTypeWiseTaskList(type);
//    }

//    public ExpenseType getSpecificExpenseType(int id) {
//        return repository.getSpecificExpenseType(id);
//    }
//
//    public ExpenseType getExpenseTypeByTenantId(int id) {
//        return repository.getExpenseTypeByTenantId(id);
//    }




}
