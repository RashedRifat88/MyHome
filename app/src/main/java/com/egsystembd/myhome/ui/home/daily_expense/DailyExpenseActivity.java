package com.egsystembd.myhome.ui.home.daily_expense;

import static com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityDailyExpenseBinding;
import com.egsystembd.myhome.model.daily_expense.Expense;
import com.egsystembd.myhome.ui.home.daily_expense.adapter.DailyExpenseAdapter;
import com.egsystembd.myhome.view_model.daily_expense.ExpenseViewModel;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DailyExpenseActivity extends AppCompatActivity {


    private ActivityDailyExpenseBinding binding;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    ExpenseViewModel expenseViewModel;
    DailyExpenseAdapter adapter;

    String defaultMonth = "";
    String defaultYear = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_daily_expense);
        binding = ActivityDailyExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initStatusBar();
        initComponents();

        expenseViewModel = new ViewModelProvider(this).get(ExpenseViewModel.class);
        expenseViewModel.getAllExpense.observe(this, tenantList -> {
            setAdapter(tenantList);
//            filteredNoteList = notes;
        });


        defaultMonthYearSet();
        datePickerCus();

    }

    private void defaultMonthYearSet() {
        Date c = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            c = Calendar.getInstance().getTime();
        }

        SimpleDateFormat df = new SimpleDateFormat("MMMM", Locale.getDefault());
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy", Locale.getDefault());
        defaultMonth = df.format(c);
        defaultYear = df2.format(c);

        binding.tvMonth.setText(defaultMonth);
        binding.tvYear.setText(String.valueOf(defaultYear));
    }

    private void datePickerCus() {

        binding.tvSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    cal = Calendar.getInstance();
                }
                int year = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    year = cal.get(Calendar.YEAR);
                }
                int month = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    month = cal.get(Calendar.MONTH);
                }
                int day = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    day = cal.get(Calendar.DAY_OF_MONTH);
                }

                DatePickerDialog dialog = new DatePickerDialog(
                        DailyExpenseActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getDatePicker().findViewById(getResources().getIdentifier("day", "id", "android")).setVisibility(View.GONE);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("tag4", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
//                    binding.tvDate.setText(date);

                String monthName = getMonthName(month);

                binding.tvMonth.setText(monthName);
                binding.tvYear.setText(String.valueOf(year));
//                    contract_start_date = date;

            }
        };

    }

    private String getMonthName(int month) {

        String monthName = "";

        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }

        return monthName;
    }


    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary2, this.getTheme()));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary2));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
        }
    }


    private void initComponents() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.linearAddExpense.setOnClickListener(v -> {
            Intent intent = new Intent(DailyExpenseActivity.this, AddDailyExpenseActivity.class);
            startActivity(intent);
        });


    }

    private void setAdapter(List<Expense> tenantList) {

        Log.d("tag666", "note number: " + tenantList.size());
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter = new DailyExpenseAdapter(this, tenantList);
        binding.recyclerView.setAdapter(adapter);
    }


}