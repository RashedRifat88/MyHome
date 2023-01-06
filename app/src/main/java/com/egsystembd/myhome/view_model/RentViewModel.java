package com.egsystembd.myhome.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.model.house_rent.Rent;
import com.egsystembd.myhome.model.house_rent.RentCollection;
import com.egsystembd.myhome.repository.RentRepository;

import java.util.List;

public class RentViewModel extends AndroidViewModel {

    RentRepository repository;
    public LiveData<List<Rent>> getAllRent;

    public LiveData<List<Rent>> getLowToHighRent;
    public LiveData<List<Rent>> getHighToLowRent;

    public RentViewModel(Application application) {
        super(application);

        repository = new RentRepository(application);
        getAllRent = repository.getAllRent;

        getHighToLowRent = repository.getHighToLowRent;
        getLowToHighRent = repository.getLowToHighRent;
    }

//    public void insertRent(Rent notes) {
//        repository.insertRent(notes);
//    }

    public long insertRent1(Rent rents) {
       return repository.insertRent1(rents);
    }

    public void deleteRent(int id) {
        repository.deleteRent(id);
    }

    public void updateRent(Rent notes) {
        repository.updateRent(notes);
    }

//    public void deleteAllRent() {
//        repository.deleteAllRent();
//    }
//
//    public LiveData<List<Rent>> getDivisionList() {
//        return repository.getDivisionList();
//    }
//
//    public List<Rent> getDistrictList(String division) {
//        return repository.getDistrictList(division);
//    }
//
//    public List<Rent> getThanaList(String district) {
//        return repository.getThanaList(district);
//    }

//    public LiveData<List<Rent>> getTypeWiseTaskList(String type) {
//        return repository.getTypeWiseTaskList(type);
//    }

    public Rent getSpecificRent(int id, int year, int deedId) {
        return repository.getSpecificRent(id, year, deedId);
    }


}
