package com.egsystembd.myhome.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.egsystembd.myhome.dao.ProfileDao;
import com.egsystembd.myhome.database.MyHomeDatabase;
import com.egsystembd.myhome.model.Profile;


public class ProfileRepository {

    public ProfileDao profileDao;
    public LiveData<Profile> getProfile;



    public ProfileRepository(Application application) {
        MyHomeDatabase database = MyHomeDatabase.getDatabaseInstance(application);
        profileDao = database.profileDao();
        getProfile = profileDao.getProfile();
    }

    public void insertProfile(Profile profile) {
        profileDao.insertProfile(profile);
    }

    public void deleteProfile(int id) {
        profileDao.deleteProfile(id);
    }

    public void updateProfile(Profile profile) {
        profileDao.updateProfile(profile);
    }

//    public LiveData<List<Profile>> getTypeWiseTaskList(String type) {
//        return profileDao.getTypeWiseTaskList(type);
//    }


}
