package com.egsystembd.myhome.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;
import com.egsystembd.myhome.repository.DivisionDistrictThanaRepository;

import java.util.List;

public class DivisionDistrictThanaViewModel extends AndroidViewModel {

    DivisionDistrictThanaRepository repository;
    public LiveData<List<DivisionDistrictThana>> getAllDivisionDistrictThana;

    public LiveData<List<DivisionDistrictThana>> getLowToHighDivisionDistrictThana;
    public LiveData<List<DivisionDistrictThana>> getHighToLowDivisionDistrictThana;

    public DivisionDistrictThanaViewModel(Application application) {
        super(application);

        repository = new DivisionDistrictThanaRepository(application);
        getAllDivisionDistrictThana = repository.getAllDivisionDistrictThana;

        getHighToLowDivisionDistrictThana = repository.getHighToLowDivisionDistrictThana;
        getLowToHighDivisionDistrictThana = repository.getLowToHighDivisionDistrictThana;
    }

    public void insertDivisionDistrictThana(DivisionDistrictThana notes) {
        repository.insertDivisionDistrictThana(notes);
    }

    public void deleteDivisionDistrictThana(int id) {
        repository.deleteDivisionDistrictThana(id);
    }

    public void deleteAllDivisionDistrictThana() {
        repository.deleteAllDivisionDistrictThana();
    }

    public void updateDivisionDistrictThana(DivisionDistrictThana notes) {
        repository.updateDivisionDistrictThana(notes);
    }

    public LiveData<List<DivisionDistrictThana>> getDivisionList() {
        return repository.getDivisionList();
    }

    public List<DivisionDistrictThana> getDistrictList(String division) {
        return repository.getDistrictList(division);
    }

    public List<DivisionDistrictThana> getThanaList(String district) {
        return repository.getThanaList(district);
    }

//    public LiveData<List<DivisionDistrictThana>> getTypeWiseTaskList(String type) {
//        return repository.getTypeWiseTaskList(type);
//    }
//


}
