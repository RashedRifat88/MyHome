package com.egsystembd.myhome.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.model.house_rent.Deed;
import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.repository.DeedRepository;

import java.util.List;

public class DeedViewModel extends AndroidViewModel {

    DeedRepository repository;
    public LiveData<List<Deed>> getAllDeed;

    public LiveData<List<Deed>> getLowToHighDeed;
    public LiveData<List<Deed>> getHighToLowDeed;

    public DeedViewModel(Application application) {
        super(application);

        repository = new DeedRepository(application);
        getAllDeed = repository.getAllDeed;

        getHighToLowDeed = repository.getHighToLowDeed;
        getLowToHighDeed = repository.getLowToHighDeed;
    }

    public void insertDeed(Deed notes) {
        repository.insertDeed(notes);
    }

    public void deleteDeed(int id) {
        repository.deleteDeed(id);
    }

    public void updateDeed(Deed notes) {
        repository.updateDeed(notes);
    }

//    public void deleteAllDeed() {
//        repository.deleteAllDeed();
//    }
//
//    public LiveData<List<Deed>> getDivisionList() {
//        return repository.getDivisionList();
//    }
//
//    public List<Deed> getDistrictList(String division) {
//        return repository.getDistrictList(division);
//    }
//
//    public List<Deed> getThanaList(String district) {
//        return repository.getThanaList(district);
//    }

//    public LiveData<List<Deed>> getTypeWiseTaskList(String type) {
//        return repository.getTypeWiseTaskList(type);
//    }

    public Deed getSpecificDeed(int id) {
        return repository.getSpecificDeed(id);
    }

    public Deed getDeedByTenantId(int id) {
        return repository.getDeedByTenantId(id);
    }




}
