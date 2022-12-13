package com.egsystembd.myhome.dao.daily_expense;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.daily_expense.ExpenseType;

import java.util.List;

@Dao
public interface ExpenseTypeDao {

    @Query("select * from table_expense_type")
    LiveData<List<ExpenseType>> getAllExpenseType();

    @Query("select * from table_expense_type order by id desc")
    LiveData<List<ExpenseType>> getExpenseTypeHighToLow();

    @Query("select * from table_expense_type order by id asc")
    LiveData<List<ExpenseType>> getExpenseTypeLowToHigh();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExpenseType(ExpenseType... ExpenseTypes);

    @Query("delete from table_expense_type where id = :id")
    void deleteExpenseType(int id);

//    @Query("delete from table_expense_type")
//    void deleteAllExpenseType();

    @Update
    void updateExpenseType(ExpenseType ExpenseType);

//    @Query("SELECT DISTINCT * FROM table_expense_type WHERE task_type = :type")
//    LiveData<List<ExpenseType>> getTypeWiseTaskList(String type);

//    @Query("SELECT * FROM table_expense_type WHERE tenant_id = :id")
//    ExpenseType getSpecificExpenseType(int id);

//    @Query("SELECT * FROM table_expense_type WHERE tenant_id = :id")
//    ExpenseType getExpenseTypeByTenantId(int id);


}
