package com.egsystembd.myhome.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.model.house_rent.Months;
import com.egsystembd.myhome.repository.MonthRepository;

import java.util.List;

public class MonthsViewModel extends AndroidViewModel {

    MonthRepository repository;
    public LiveData<List<Months>> getAllMonth;

    public LiveData<List<Months>> getLowToHighMonth;
    public LiveData<List<Months>> getHighToLowMonth;

    public MonthsViewModel(Application application) {
        super(application);

        repository = new MonthRepository(application);
        getAllMonth = repository.getAllMonth;

        getHighToLowMonth = repository.getHighToLowMonth;
        getLowToHighMonth = repository.getLowToHighMonth;
    }

    public void insertMonth(Months notes) {
        repository.insertMonth(notes);
    }

    public void deleteMonth(int id) {
        repository.deleteMonth(id);
    }

    public void deleteAllMonth() {
        repository.deleteAllMonth();
    }

    public void updateMonth(Months notes) {
        repository.updateMonth(notes);
    }

//    public LiveData<List<Month>> getDivisionList() {
//        return repository.getDivisionList();
//    }
//
//    public List<Month> getDistrictList(String division) {
//        return repository.getDistrictList(division);
//    }
//
//    public List<Month> getThanaList(String district) {
//        return repository.getThanaList(district);
//    }

//    public LiveData<List<Month>> getTypeWiseTaskList(String type) {
//        return repository.getTypeWiseTaskList(type);
//    }
//


}
