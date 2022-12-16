package com.egsystembd.myhome.ui.home.daily_expense;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityAddDailyExpenseBinding;
import com.egsystembd.myhome.databinding.ActivityAddTenantBinding;
import com.egsystembd.myhome.model.daily_expense.Expense;
import com.egsystembd.myhome.model.daily_expense.ExpenseType;
import com.egsystembd.myhome.model.house_rent.Deed;
import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;
import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.view_model.DeedViewModel;
import com.egsystembd.myhome.view_model.DivisionDistrictThanaViewModel;
import com.egsystembd.myhome.view_model.RentCollectionViewModel;
import com.egsystembd.myhome.view_model.TenantViewModel;
import com.egsystembd.myhome.view_model.daily_expense.ExpenseTypeViewModel;
import com.egsystembd.myhome.view_model.daily_expense.ExpenseViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class AddDailyExpenseActivity extends AppCompatActivity {

    private ActivityAddDailyExpenseBinding binding;

    String amount = "";
    String mobile_number = "";
    String expense_type = "";
    String present_expense_type_id = "";
    String selectedDate = "";
    String selectedMonth = "";
    String selectedYear = "";


    ArrayAdapter<String> dataAdapter;
    Spinner spinner_medical_college, spinner_gender, spinner_blood_group, spinner_expense_type, spinner_district, spinner_upazila;
    List<String> medical_college_list, gender_list, blood_group_list, expense_type_list, district_list, upazila_list;

    HashMap<String, String> expense_typeIdMap;


    ExpenseTypeViewModel expenseTypeViewModel;
    ExpenseViewModel expenseViewModel;
    List<ExpenseType> type_list = new ArrayList<>();

    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_add_daily_expense);
        binding = ActivityAddDailyExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        expenseViewModel = new ViewModelProvider(this).get(ExpenseViewModel.class);

        expenseTypeViewModel = new ViewModelProvider(this).get(ExpenseTypeViewModel.class);

//        expenseTypeViewModel.getAllExpenseType.observe(this, expenseTypes -> {
//
//        });

        initComponents();

        spinner_expense_type();

        defaultMonthYearSet();
        loadCalender_contract_start_date();


    }

    private void initComponents() {

        spinner_expense_type = findViewById(R.id.spinner_expense_type);
        spinner_district = findViewById(R.id.spinner_district);
        spinner_upazila = findViewById(R.id.spinner_upazila);

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.linearSave.setOnClickListener(v -> {
//            Intent intent = new Intent(AddDailyExpenseActivity.this, AddDailyExpenseActivity.class);
//            startActivity(intent);
            addNewExpense();
        });

        binding.tvAddExpenseType.setOnClickListener(v -> {
            addNewExpenseType();
        });


    }

    private void addNewExpenseType() {
        Intent intent = new Intent(AddDailyExpenseActivity.this, AddExpenseTypeActivity.class);
        startActivity(intent);
    }

    private void defaultMonthYearSet() {
        Date c = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            c = Calendar.getInstance().getTime();
        }

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        selectedDate = df.format(c);

        SimpleDateFormat df2 = new SimpleDateFormat("MM", Locale.getDefault());
        selectedMonth = df2.format(c);

        SimpleDateFormat df3 = new SimpleDateFormat("yyyy", Locale.getDefault());
        selectedYear = df3.format(c);

        binding.tvDate.setText(selectedDate);
    }

    private void loadCalender_contract_start_date() {

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
                        AddDailyExpenseActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("tag4", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "/" + month + "/" + year;
                binding.tvDate.setText(date);
                selectedDate = date;
                selectedMonth = String.valueOf(month);
                selectedYear = String.valueOf(year);
//                Toast.makeText(AddDailyExpenseActivity.this, "contract_start_date:" + contract_start_date, Toast.LENGTH_SHORT).show();

                binding.linearDate.setBackgroundColor(ContextCompat.getColor(AddDailyExpenseActivity.this, R.color.transparent));
            }
        };

    }


    private void addNewExpense() {
        checkValues();
    }

    private void checkValues() {

        if (binding.etAmount.getText().toString().isEmpty()) {
            binding.etAmount.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            amount = binding.etAmount.getText().toString();
        }


        if (this.expense_type.equalsIgnoreCase("ব্যয়ের খাত সিলেক্ট")) {
            binding.relativeExpenseType.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
        } else {
            expense_type = this.expense_type;
        }


        if (amount.isEmpty() || this.expense_type.equalsIgnoreCase("ব্যয়ের খাত সিলেক্ট")) {

            Toast.makeText(this, "দয়া করে সবগুলো ঘর পূরণ করুন", Toast.LENGTH_SHORT).show();

        } else {

            Expense obj1 = new Expense();
            obj1.date = selectedDate;
            obj1.month = selectedMonth;
            obj1.year = selectedYear;
            obj1.expense_name = expense_type;
            obj1.amount = Double.valueOf(amount);

            expenseViewModel.insertExpense(obj1);


            Toast.makeText(this, "খরচ সফলভাবে তৈরি হয়েছে", Toast.LENGTH_SHORT).show();
            finish();


        }


    }


    private void spinner_expense_type() {

        getTypeData();

        spinner_expense_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
                String item = parent.getItemAtPosition(position).toString();
                Log.d("tag4", "item : " + item);
                if (!item.isEmpty() && item != null) {
                    present_expense_type_id = expense_typeIdMap.get(item);
                    expense_type = item;

                    binding.relativeExpenseType.setBackground(ContextCompat.getDrawable(AddDailyExpenseActivity.this, R.drawable.edit_text_bg_1));

                } else {

                }
                Log.d("tag4", "expense_type_id : " + present_expense_type_id);

//                if (position == 0) {
//                    ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorHint));
//                } else {
//                    ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimary));
//                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }


    @SuppressLint("CheckResult")
    public void getTypeData() {

        expense_type_list = new ArrayList<String>();
        expense_typeIdMap = new HashMap<String, String>();



//        expense_type_list.add("বাসা ভাড়া");
//        expense_type_list.add("বাজার");
//        expense_type_list.add("জামা কাপড়");
//        expense_type_list.add("উপহার");
//        expense_type_list.add("কাজের লোকের বেতন");
//        expense_type_list.add("ড্রাইভার বেতন");
//        expense_type_list.add("গার্ড বেতন");
//        expense_type_list.add("স্কুলের বেতন");
//        expense_type_list.add("টিউটর ফী");
//        expense_type_list.add("মেডিকেল");
//        expense_type_list.add("ঔষধ");
//        expense_type_list.add("সম্পদ");
//        expense_type_list.add("অনুদান");


        expenseTypeViewModel.getAllExpenseType.observe(this, expenseTypes -> {
            Log.d("tag4", "expenseTypes: " + expenseTypes);
            expense_type_list.clear();
            expense_type_list.add("ব্যয়ের খাত সিলেক্ট");

            Log.d("tag4", "expense_type_list1: " + expense_type_list);

            type_list = expenseTypes;

            for (ExpenseType expense_type : type_list) {
                expense_type_list.add(expense_type.name);
                expense_typeIdMap.put(String.valueOf(expense_type.id), expense_type.name);
            }

            Log.d("tag4", "expense_type_list2: " + expense_type_list);

        });


        dataAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item, expense_type_list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_expense_type.setAdapter(dataAdapter);

    }


}