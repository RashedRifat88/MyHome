package com.egsystembd.myhome.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.repository.TenantRepository;

import java.util.List;

public class TenantViewModel extends AndroidViewModel {

    TenantRepository repository;
    public LiveData<List<Tenant>> getAllTenant;

    public LiveData<List<Tenant>> getLowToHighTenant;
    public LiveData<List<Tenant>> getHighToLowTenant;

    public TenantViewModel(Application application) {
        super(application);

        repository = new TenantRepository(application);
        getAllTenant = repository.getAllTenant;

        getHighToLowTenant = repository.getHighToLowTenant;
        getLowToHighTenant = repository.getLowToHighTenant;
    }

    public long insertTenant1(Tenant notes) {
        return repository.insertTenant1(notes);
    }

    public void deleteTenant(int id) {
        repository.deleteTenant(id);
    }

    public void deleteAllTenant() {
        repository.deleteAllTenant();
    }

    public void updateTenant(Tenant notes) {
        repository.updateTenant(notes);
    }

//    public LiveData<List<Tenant>> getDivisionList() {
//        return repository.getDivisionList();
//    }
//
//    public List<Tenant> getDistrictList(String division) {
//        return repository.getDistrictList(division);
//    }
//
//    public List<Tenant> getThanaList(String district) {
//        return repository.getThanaList(district);
//    }

//    public LiveData<List<Tenant>> getTypeWiseTaskList(String type) {
//        return repository.getTypeWiseTaskList(type);
//    }
//

//    public int getTenantId(Tenant tenant) {
//        return repository.getTenantId(tenant);
//    }

    public Tenant getTenantById(int id) {
        return repository.getTenantById(id);
    }



}
