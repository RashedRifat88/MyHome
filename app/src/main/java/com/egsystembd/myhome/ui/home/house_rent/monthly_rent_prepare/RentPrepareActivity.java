package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityRentPrepareBinding;
import com.egsystembd.myhome.model.house_rent.Deed;
import com.egsystembd.myhome.model.house_rent.Rent;
import com.egsystembd.myhome.model.house_rent.RentCollection;
import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.view_model.DeedViewModel;
import com.egsystembd.myhome.view_model.RentCollectionViewModel;
import com.egsystembd.myhome.view_model.RentViewModel;
import com.egsystembd.myhome.view_model.TenantViewModel;

public class RentPrepareActivity extends AppCompatActivity {

    private ActivityRentPrepareBinding binding;

    TenantViewModel tenantViewModel;
    DeedViewModel deedViewModel;
    RentViewModel rentViewModel;
    RentCollectionViewModel rentCollectionViewModel;

    String temantId = "";
    int deed_id;
    Deed deed;
    String flat_no;
    float house_rent = 0;
    float service_charge = 0;
    float advance_deduction = 0;
    float electricity_bill = 0;
    float gas_bill = 0;
    float water_bill = 0;
    float security_bill = 0;
    float cleaning_bill = 0;
    float garage_bill = 0;
    float common_bill = 0;
    float others = 0;

    float total_rent = 0;
    float net_rent = 0;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String month_year = "";
    private int month1 = 0;
    private int year1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fare_prepare);

        binding = ActivityRentPrepareBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tenantViewModel = new ViewModelProvider(this).get(TenantViewModel.class);
        deedViewModel = new ViewModelProvider(this).get(DeedViewModel.class);
        rentViewModel = new ViewModelProvider(this).get(RentViewModel.class);
        rentCollectionViewModel = new ViewModelProvider(this).get(RentCollectionViewModel.class);

        temantId = getIntent().getStringExtra("tenant_id");
        int id = Integer.parseInt(temantId);
        deed = deedViewModel.getSpecificDeed(id);
        deed_id = deed.id;

        initComponents();
        setAutofillValues();
        getEditTextDatas();

        calculateRent();
        getEditTextChanges();
        loadCalender_month_year();

    }


    private void setAutofillValues() {
        flat_no = deed.flat_no;
        house_rent = deed.monthly_rent;
        service_charge = deed.service_charge;
        advance_deduction = deed.monthly_advance_deduction;

        binding.tvFlatNo.setText(String.valueOf(flat_no));
        binding.tvMonthlyRent.setText(String.valueOf(house_rent));
        binding.tvServiceCharge.setText(String.valueOf(service_charge));
        binding.tvAdvanceDeduction.setText(String.valueOf(advance_deduction));
    }

    private void getEditTextDatas() {

        if (!binding.etElectricityBill.getText().toString().isEmpty()) {
            electricity_bill = Float.parseFloat(binding.etElectricityBill.getText().toString());
        }

        if (!binding.etGarageBill.getText().toString().isEmpty()) {
            gas_bill = Float.parseFloat(binding.etGarageBill.getText().toString());
        }

        if (!binding.etWaterBill.getText().toString().isEmpty()) {
            water_bill = Float.parseFloat(binding.etWaterBill.getText().toString());
        }

        if (!binding.etSecurityBill.getText().toString().isEmpty()) {
            security_bill = Float.parseFloat(binding.etSecurityBill.getText().toString());
        }

        if (!binding.etCleaningBill.getText().toString().isEmpty()) {
            cleaning_bill = Float.parseFloat(binding.etCleaningBill.getText().toString());
        }

        if (!binding.etGarageBill.getText().toString().isEmpty()) {
            garage_bill = Float.parseFloat(binding.etGarageBill.getText().toString());
        }

        if (!binding.etCommonBill.getText().toString().isEmpty()) {
            common_bill = Float.parseFloat(binding.etCommonBill.getText().toString());
        }

        if (!binding.etOthers.getText().toString().isEmpty()) {
            others = Float.parseFloat(binding.etOthers.getText().toString());
        }


    }

    private void calculateRent() {
        total_rent = house_rent + service_charge + electricity_bill + gas_bill + water_bill + security_bill + cleaning_bill
                + garage_bill + common_bill + others;
        net_rent = total_rent - advance_deduction;

        binding.tvTotal.setText(String.valueOf(total_rent));
        binding.tvNetRent.setText(String.valueOf(net_rent));
    }


    private void loadCalender_month_year() {

        binding.tvSelectMonth.setOnClickListener(new View.OnClickListener() {
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
                        RentPrepareActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("tag4", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

//                String date = month + "/" + day + "/" + year;
                String date = month + "/"  + year;
                binding.tvMonth.setText(date);
                month_year = date;
                year1 = year;
                month1 = month;

//                Toast.makeText(RentPrepareActivity.this, "contract_start_date:" + month_year, Toast.LENGTH_SHORT).show();
//                binding.linearMonthYear.setBackgroundColor(ContextCompat.getColor(RentPrepareActivity.this, R.color.transparent));
            }
        };

    }

    private void getEditTextChanges() {

        binding.etElectricityBill.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                electricity_bill = Float.parseFloat(binding.etElectricityBill.getText().toString());
                calculateRent();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        binding.etGasBill.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                gas_bill = Float.parseFloat(binding.etGasBill.getText().toString());
                calculateRent();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        binding.etWaterBill.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                water_bill = Float.parseFloat(binding.etWaterBill.getText().toString());
                calculateRent();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        binding.etSecurityBill.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                security_bill = Float.parseFloat(binding.etSecurityBill.getText().toString());
                calculateRent();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        binding.etCleaningBill.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                cleaning_bill = Float.parseFloat(binding.etCleaningBill.getText().toString());
                calculateRent();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        binding.etGarageBill.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                garage_bill = Float.parseFloat(binding.etGarageBill.getText().toString());
                calculateRent();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        binding.etCommonBill.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                common_bill = Float.parseFloat(binding.etCommonBill.getText().toString());
                calculateRent();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        binding.etOthers.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                others = Float.parseFloat(binding.etOthers.getText().toString());
                calculateRent();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


    }


    private void initComponents() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.linearSave.setOnClickListener(v -> {


            Log.d("tag4", "month_year: "+month_year);
            if (month_year.isEmpty()) {

                Toast.makeText(this, "দয়া করে মাস সিলেক্ট করুন", Toast.LENGTH_SHORT).show();

            } else {

                Rent obj1 = new Rent();
                obj1.deed_id = deed_id;
                obj1.year = year1;
                obj1.month_id = month1;
                obj1.rent_amount = (int) house_rent;
                obj1.service_charge = service_charge;
                obj1.electricity = electricity_bill;
                obj1.gas = gas_bill;
                obj1.water = water_bill;
                obj1.security = security_bill;
                obj1.cleaning = cleaning_bill;
                obj1.garage = garage_bill;
                obj1.common = common_bill;
                obj1.others = others;
                obj1.total_payable_rent = net_rent;

                Long rent_id = rentViewModel.insertRent1(obj1);

//                RentCollection obj2 = new RentCollection();
//                obj2.deed_id = deed_id;
//                obj2.rent_id = Integer.parseInt(String.valueOf(rent_id));
//                obj2.tenant_id = Integer.parseInt(temantId);
//                obj2.total_payable_rent = net_rent;
//                rentCollectionViewModel.updateRentCollection(obj2);


                Toast.makeText(this, "ভাড়া সফলভাবে তৈরি হয়েছে", Toast.LENGTH_SHORT).show();
                finish();

            }

        });


    }

}