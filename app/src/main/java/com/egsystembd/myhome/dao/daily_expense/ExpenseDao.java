package com.egsystembd.myhome.dao.daily_expense;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.egsystembd.myhome.model.daily_expense.Expense;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Query("select * from table_expense")
    LiveData<List<Expense>> getAllExpense();

    @Query("select * from table_expense order by id desc")
    LiveData<List<Expense>> getExpenseHighToLow();

    @Query("select * from table_expense order by id asc")
    LiveData<List<Expense>> getExpenseLowToHigh();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExpense(Expense... Expenses);

    @Query("delete from table_expense where id = :id")
    void deleteExpense(int id);

//    @Query("delete from table_expense")
//    void deleteAllExpense();

    @Update
    void updateExpense(Expense Expense);

//    @Query("SELECT DISTINCT * FROM table_expense WHERE task_type = :type")
//    LiveData<List<Expense>> getTypeWiseTaskList(String type);

//    @Query("SELECT * FROM table_expense WHERE tenant_id = :id")
//    Expense getSpecificExpense(int id);

    @Query("SELECT * FROM table_expense WHERE id = :id")
    Expense getExpenseById(int id);

    @Query("SELECT * FROM table_expense WHERE month = :month AND year = :year")
    LiveData<List<Expense>> getExpenseListByMonthAndYear(String month, String year);


}
