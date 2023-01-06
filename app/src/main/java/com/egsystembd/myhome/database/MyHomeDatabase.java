package com.egsystembd.myhome.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.egsystembd.myhome.dao.BuildingDao;
import com.egsystembd.myhome.dao.DeedDao;
import com.egsystembd.myhome.dao.DivisionDistrictThanaDao;
import com.egsystembd.myhome.dao.FlatDao;
import com.egsystembd.myhome.dao.MonthsDao;
import com.egsystembd.myhome.dao.RentCollectionDao;
import com.egsystembd.myhome.dao.RentDao;
import com.egsystembd.myhome.dao.TenantDao;
import com.egsystembd.myhome.dao.daily_expense.ExpenseDao;
import com.egsystembd.myhome.dao.daily_expense.ExpenseTypeDao;
import com.egsystembd.myhome.model.daily_expense.Expense;
import com.egsystembd.myhome.model.daily_expense.ExpenseType;
import com.egsystembd.myhome.model.house_rent.Building;
import com.egsystembd.myhome.model.house_rent.Deed;
import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;
import com.egsystembd.myhome.model.house_rent.Flat;
import com.egsystembd.myhome.model.house_rent.Months;
import com.egsystembd.myhome.model.house_rent.Rent;
import com.egsystembd.myhome.model.house_rent.RentCollection;
import com.egsystembd.myhome.model.house_rent.Tenant;


@Database(entities = {DivisionDistrictThana.class, Months.class, Building.class, Deed.class, Flat.class, Rent.class, RentCollection.class,
        Tenant.class, Expense.class, ExpenseType.class}, version = 1, exportSchema = false)
public abstract class MyHomeDatabase extends RoomDatabase {

    public abstract DivisionDistrictThanaDao divisionDistrictThanaDao();

    public abstract MonthsDao MonthsDao();
    public abstract BuildingDao BuildingDao();
    public abstract DeedDao DeedDao();
    public abstract FlatDao FlatDao();
    public abstract RentDao RentDao();
    public abstract RentCollectionDao RentCollectionDao();
    public abstract TenantDao TenantDao();
    public abstract ExpenseDao ExpenseDao();
    public abstract ExpenseTypeDao ExpenseTypeDao();


    public static MyHomeDatabase INSTANCE;

    public static MyHomeDatabase getDatabaseInstance(Context context) {

        Log.d("tag4567", "getDatabaseInstance accessed");

        if (INSTANCE == null) {
//            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyHomeDatabase.class, "my_home_database").allowMainThreadQueries()
//                    .build();
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyHomeDatabase.class, "my_home_database").allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();
            Log.d("tag4567", "database created");
        }

        return INSTANCE;
    }


}
