package com.egsystembd.myhome.view_model.daily_expense;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.egsystembd.myhome.model.daily_expense.Expense;
import com.egsystembd.myhome.repository.daily_expense.ExpenseRepository;

import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {

    ExpenseRepository repository;
    public LiveData<List<Expense>> getAllExpense;

    public LiveData<List<Expense>> getLowToHighExpense;
    public LiveData<List<Expense>> getHighToLowExpense;


    public ExpenseViewModel(Application application) {
        super(application);

        repository = new ExpenseRepository(application);
        getAllExpense = repository.getAllExpense;

        getHighToLowExpense = repository.getHighToLowExpense;
        getLowToHighExpense = repository.getLowToHighExpense;

    }

    public void insertExpense(Expense notes) {
        repository.insertExpense(notes);
    }

    public void deleteExpense(int id) {
        repository.deleteExpense(id);
    }

    public void updateExpense(Expense notes) {
        repository.updateExpense(notes);
    }

//    public void deleteAllExpense() {
//        repository.deleteAllExpense();
//    }
//
//    public LiveData<List<Expense>> getDivisionList() {
//        return repository.getDivisionList();
//    }
//
//    public List<Expense> getDistrictList(String division) {
//        return repository.getDistrictList(division);
//    }
//
//    public List<Expense> getThanaList(String district) {
//        return repository.getThanaList(district);
//    }

//    public LiveData<List<Expense>> getTypeWiseTaskList(String type) {
//        return repository.getTypeWiseTaskList(type);
//    }

    //    public Expense getSpecificExpense(int id) {
//        return repository.getSpecificExpense(id);
//    }
//
    public Expense getExpenseById(int id) {
        return repository.getExpenseById(id);
    }

    public LiveData<List<Expense>> getExpenseListByMonthAndYear(String month, String year) {
        return repository.getExpenseListByMonthAndYear(month, year);
    }

    public double getTotalExpenseByMonthAndYear(String month, String year) {
        return repository.getTotalExpenseByMonthAndYear(month, year);
    }


}
