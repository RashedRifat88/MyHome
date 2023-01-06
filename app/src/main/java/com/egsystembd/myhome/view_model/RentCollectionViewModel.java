package com.egsystembd.myhome.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.model.house_rent.Rent;
import com.egsystembd.myhome.model.house_rent.RentCollection;
import com.egsystembd.myhome.repository.RentCollectionRepository;

import java.util.List;

public class RentCollectionViewModel extends AndroidViewModel {

    RentCollectionRepository repository;
    public LiveData<List<RentCollection>> getAllRentCollection;

    public LiveData<List<RentCollection>> getLowToHighRentCollection;
    public LiveData<List<RentCollection>> getHighToLowRentCollection;

    public RentCollectionViewModel(Application application) {
        super(application);

        repository = new RentCollectionRepository(application);
        getAllRentCollection = repository.getAllRentCollection;

        getHighToLowRentCollection = repository.getHighToLowRentCollection;
        getLowToHighRentCollection = repository.getLowToHighRentCollection;
    }

    public void insertRentCollection(RentCollection notes) {
        repository.insertRentCollection(notes);
    }

    public void deleteRentCollection(int id) {
        repository.deleteRentCollection(id);
    }

    public void updateRentCollection(RentCollection notes) {
        repository.updateRentCollection(notes);
    }

//    public void deleteAllRentCollection() {
//        repository.deleteAllRentCollection();
//    }
//
//    public LiveData<List<RentCollection>> getDivisionList() {
//        return repository.getDivisionList();
//    }
//
//    public List<RentCollection> getDistrictList(String division) {
//        return repository.getDistrictList(division);
//    }
//
//    public List<RentCollection> getThanaList(String district) {
//        return repository.getThanaList(district);
//    }

//    public LiveData<List<RentCollection>> getTypeWiseTaskList(String type) {
//        return repository.getTypeWiseTaskList(type);
//    }

    public RentCollection getSpecificRentCollection(int id) {
        return repository.getSpecificRentCollection(id);
    }

    public RentCollection getSpecificRentCollection(int deedId, int year, int monthId) {
        return repository.getSpecificRentCollection(deedId, year, monthId);
    }




}
