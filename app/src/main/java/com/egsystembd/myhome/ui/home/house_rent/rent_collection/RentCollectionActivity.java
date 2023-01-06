package com.egsystembd.myhome.ui.home.house_rent.rent_collection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityMonthlyRentPrepareBinding;
import com.egsystembd.myhome.databinding.ActivityRentCollectionBinding;
import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.ui.home.house_rent.rent_collection.adapter.RentCollectionAdapter;
import com.egsystembd.myhome.ui.home.house_rent.tenant.AddTenantActivity;
import com.egsystembd.myhome.view_model.TenantViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RentCollectionActivity extends AppCompatActivity {

    private ActivityRentCollectionBinding binding;

    TenantViewModel tenantViewModel;
    RentCollectionAdapter adapter;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    int selectedMonth;
    int selectedYear;

    String defaultMonth = "";
    String defaultYear = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rent_collection);
        binding = ActivityRentCollectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initStatusBar();
        initComponents();

        defaultMonthYearSet();

        tenantViewModel = new ViewModelProvider(this).get(TenantViewModel.class);
        tenantViewModel.getAllTenant.observe(this, tenantList -> {
            setAdapter(tenantList,selectedYear, selectedMonth);
        });


        datePickerCus();
    }

    private void initComponents() {
        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

//        binding.linearAddTenant.setOnClickListener(v -> {
//            Intent intent = new Intent(RentCollectionActivity.this, AddTenantActivity.class);
//            startActivity(intent);
//        });

    }


    private void defaultMonthYearSet() {
        Date c = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            c = Calendar.getInstance().getTime();
        }

        SimpleDateFormat df = new SimpleDateFormat("MMMM", Locale.getDefault());
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy", Locale.getDefault());
        SimpleDateFormat df3 = new SimpleDateFormat("M", Locale.getDefault());
        defaultMonth = df.format(c);
        defaultYear = df2.format(c);
        int defaultMonthNumber = Integer.parseInt(df3.format(c));

        selectedMonth = defaultMonthNumber;
        selectedYear = Integer.parseInt(defaultYear);

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
                        RentCollectionActivity.this,
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
                selectedMonth = month;
                selectedYear = year;

                tenantViewModel.getAllTenant.observe(RentCollectionActivity.this, tenantList -> {
                    setAdapter(tenantList, selectedYear, selectedMonth);
                });


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



    private void setAdapter(List<Tenant> tenantList, int year, int monthId) {

        Log.d("tag666", "note number: " + tenantList.size());
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter = new RentCollectionAdapter(this, tenantList, year, monthId);
        binding.recyclerView.setAdapter(adapter);
    }



}