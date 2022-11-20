//package com.egsystembd.myhome.dao;
//
//import androidx.lifecycle.LiveData;
//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import com.egsystembd.myhome.model.Profile;
//
//
//@Dao
//public interface ProfileDao {
//
//    @Query("select * from table_profile")
//    LiveData<Profile> getProfile();
//
//
//    @Insert
//    void insertProfile(Profile... profiles);
//
//    @Query("delete from table_profile where id = :id")
//    void deleteProfile(int id);
//
//    @Update
//    void updateProfile(Profile profile);
//
//
////    @Query("SELECT DISTINCT * FROM table_profile WHERE task_type = :type")
////    LiveData<List<Profile>> getTypeWiseTaskList (String type);
//
//}
