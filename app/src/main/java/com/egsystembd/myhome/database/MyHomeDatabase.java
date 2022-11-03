package com.egsystembd.myhome.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.egsystembd.myhome.dao.HouseRentDao;
import com.egsystembd.myhome.dao.ProfileDao;
import com.egsystembd.myhome.model.HouseRent;
import com.egsystembd.myhome.model.Profile;


@Database(entities = {HouseRent.class, Profile.class}, version = 1)
public abstract class MyHomeDatabase extends RoomDatabase {

    public abstract HouseRentDao HouseRentDao();
    public abstract ProfileDao profileDao();


    public static MyHomeDatabase INSTANCE;

    public static MyHomeDatabase getDatabaseInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyHomeDatabase.class, "my_home_database").allowMainThreadQueries().build();
        }

        return INSTANCE;
    }




}
