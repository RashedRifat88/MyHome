package com.egsystembd.myhome.ui.home.house_rent.tenant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
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
import com.egsystembd.myhome.databinding.ActivityAddTenantBinding;
import com.egsystembd.myhome.model.house_rent.Deed;
import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;
import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.view_model.DeedViewModel;
import com.egsystembd.myhome.view_model.DivisionDistrictThanaViewModel;
import com.egsystembd.myhome.view_model.RentCollectionViewModel;
import com.egsystembd.myhome.view_model.TenantViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddTenantActivity extends AppCompatActivity {

    private ActivityAddTenantBinding binding;

    String name = "";
    String mobile_number = "";
    String nid = "";
    String division = "";
    String district = "";
    String upazila = "";
    String post_office = "";
    String village = "";

    String flat_no = "";
    String monthly_rent = "";
    String service_charge = "";
    String total_advance = "";
    String monthly_advance_deduction = "";
    String contract_start_date = "";
    String contract_duration = "";
    String contract_validity = "";


    String date_of_birth = "";
    String bmdc_no = "";
    String email = "";
    String facebook_id = "";
    String job_description = "";
    String passport = "";
    String present_division_id = "";
    String present_district_id = "";
    String present_upazila_id = "";
    String present_address = "";
    String medical_college = "";
    String gender = "";
    String blood_group = "";

    ArrayAdapter<String> dataAdapter;
    Spinner spinner_medical_college, spinner_gender, spinner_blood_group, spinner_division, spinner_district, spinner_upazila;
    String medical_college_id;
    List<String> medical_college_list, gender_list, blood_group_list, division_list, district_list, upazila_list;
    HashMap<String, String> medicalCollegeIdMap;
    HashMap<String, String> divisionIdMap;
    HashMap<String, String> districtIdMap;
    HashMap<String, String> upazilaIdMap;

    DivisionDistrictThanaViewModel divisionDistrictThanaViewModel;
    TenantViewModel tenantViewModel;
    DeedViewModel deedViewModel;
    RentCollectionViewModel rentCollectionViewModel;
    List<DivisionDistrictThana> div_list;

    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_add_tenant);
        binding = ActivityAddTenantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        divisionDistrictThanaViewModel = new ViewModelProvider(this).get(DivisionDistrictThanaViewModel.class);
        tenantViewModel = new ViewModelProvider(this).get(TenantViewModel.class);
        deedViewModel = new ViewModelProvider(this).get(DeedViewModel.class);
        rentCollectionViewModel = new ViewModelProvider(this).get(RentCollectionViewModel.class);

        initComponents();

        spinner_division();
        loadCalender_contract_start_date();


    }

    private void initComponents() {

        spinner_division = findViewById(R.id.spinner_division);
        spinner_district = findViewById(R.id.spinner_district);
        spinner_upazila = findViewById(R.id.spinner_upazila);

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.linearSave.setOnClickListener(v -> {
//            Intent intent = new Intent(AddTenantActivity.this, AddTenantActivity.class);
//            startActivity(intent);
            addNewTenant();
        });


    }


    private void addNewTenant() {
        checkValues();
    }

    private void checkValues() {
        String name = "";
        String mobile_number = "";
        String nid = "";
        String division = "";
        String district = "";
        String upazila = "";
        String post_office = "";
        String village = "";

        String flat_no = "";
        String monthly_rent = "";
        String service_charge = "";
        String total_advance = "";
        String monthly_advance_deduction = "";
        String contract_start_date = "";
        String contract_duration = "";
        String contract_validity = "";

        if (binding.etTenantName.getText().toString().isEmpty()) {
            binding.etTenantName.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            name = binding.etTenantName.getText().toString();
        }


        if (binding.etTenantMobile.getText().toString().isEmpty()) {
            binding.etTenantMobile.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            mobile_number = binding.etTenantMobile.getText().toString();
        }


        if (binding.etTenantNid.getText().toString().isEmpty()) {
            binding.etTenantNid.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            nid = binding.etTenantNid.getText().toString();
        }


        if (this.division.equalsIgnoreCase("বিভাগ সিলেক্ট")) {
            binding.relativeDivision.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
        } else {
            division = this.division;
        }

        Log.d("this.division", "this.division: " + this.division);


        if (this.district.equalsIgnoreCase("জেলা সিলেক্ট")) {
            binding.relativeDistrict.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
        } else {
            district = this.district;
        }

        Log.d("this.division", "this.district: " + this.district);


        if (this.upazila.equalsIgnoreCase("থানা সিলেক্ট")) {
            binding.relativeUpazila.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
        } else {
            upazila = this.upazila;
        }


        if (binding.etPostOffice.getText().toString().isEmpty()) {
            binding.etPostOffice.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            post_office = binding.etPostOffice.getText().toString();
        }


        if (binding.etVillage.getText().toString().isEmpty()) {
            binding.etVillage.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            village = binding.etVillage.getText().toString();
        }


        if (binding.etFlatNo.getText().toString().isEmpty()) {
            binding.etFlatNo.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            flat_no = binding.etFlatNo.getText().toString();
        }


        if (binding.etMonthlyRent.getText().toString().isEmpty()) {
            binding.etMonthlyRent.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            monthly_rent = binding.etMonthlyRent.getText().toString();
        }


        if (binding.etServiceCharge.getText().toString().isEmpty()) {
            binding.etServiceCharge.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            service_charge = binding.etServiceCharge.getText().toString();
        }


        if (binding.etTotalAdvance.getText().toString().isEmpty()) {
            binding.etTotalAdvance.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            total_advance = binding.etTotalAdvance.getText().toString();
        }


        if (binding.etMonthlyAdvanceDeduction.getText().toString().isEmpty()) {
            binding.etMonthlyAdvanceDeduction.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            monthly_advance_deduction = binding.etMonthlyAdvanceDeduction.getText().toString();
        }


        if (this.contract_start_date == null || this.contract_start_date.isEmpty()) {
            binding.linearContractStartDate.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
        } else {
            contract_start_date = this.contract_start_date;
        }


        if (binding.etContractDuration.getText().toString().isEmpty()) {
            binding.etContractDuration.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            contract_duration = binding.etContractDuration.getText().toString();
        }




        if (name.isEmpty() || mobile_number.isEmpty() || nid.isEmpty() || this.division.equalsIgnoreCase("বিভাগ সিলেক্ট") ||
                this.district.equalsIgnoreCase("জেলা সিলেক্ট") || this.upazila.equalsIgnoreCase("থানা সিলেক্ট") ||
                post_office.isEmpty() || village.isEmpty() || flat_no.isEmpty() || monthly_rent.isEmpty() || service_charge.isEmpty() || total_advance.isEmpty() ||
                monthly_advance_deduction.isEmpty() || contract_start_date.isEmpty() || contract_duration.isEmpty()) {

            Toast.makeText(this, "দয়া করে সবগুলো ঘর পূরণ করুন", Toast.LENGTH_SHORT).show();

        } else {

            Tenant obj1 = new Tenant();
            obj1.name = name;
            obj1.phone = mobile_number;
            obj1.nid = nid;
            obj1.devision = division;
            obj1.district = district;
            obj1.thana = upazila;
            obj1.post_office = post_office;
            obj1.area = village;

            Long id = tenantViewModel.insertTenant1(obj1);


            Deed obj2 = new Deed();
            obj2.tenant_id = Integer.parseInt(String.valueOf(id));
            obj2.flat_no = flat_no;
            obj2.monthly_rent = Float.parseFloat(monthly_rent);
            obj2.service_charge = Float.parseFloat(service_charge);
            obj2.total_advance = Float.parseFloat(total_advance);
            obj2.monthly_advance_deduction = Float.parseFloat(monthly_advance_deduction.toString());
            obj2.contract_start_date = contract_start_date.toString();
            obj2.contract_duration = contract_duration;

            deedViewModel.insertDeed(obj2);


//            RentCollection obj3 = new RentCollection();
//            obj3.tenant_id = Integer.parseInt(String.valueOf(id));
//            obj3.total_payable_rent = 0;
//            rentCollectionViewModel.insertRentCollection(obj3);


            Log.d("tag4", "monthly_advance_deduction: " + monthly_advance_deduction.toString());
            Log.d("tag4", "contract_start_date: " + contract_start_date.toString());


            Toast.makeText(this, "ভাড়াটিয়া সফলভাবে তৈরি হয়েছে", Toast.LENGTH_SHORT).show();
            finish();


        }



    }

    private void loadCalender_contract_start_date() {

        binding.tvSelectContractStartDate.setOnClickListener(new View.OnClickListener() {
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
                        AddTenantActivity.this,
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

                String date = month + "/" + day + "/" + year;
                binding.tvContractStartDate.setText(date);
                contract_start_date = date;
//                Toast.makeText(AddTenantActivity.this, "contract_start_date:" + contract_start_date, Toast.LENGTH_SHORT).show();

                binding.linearContractStartDate.setBackgroundColor(ContextCompat.getColor(AddTenantActivity.this, R.color.transparent));
            }
        };

    }


    private void spinner_division() {

        getDivisionData();

        spinner_division.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
                String item = parent.getItemAtPosition(position).toString();
                if (!item.isEmpty() && item != null) {
                    present_division_id = divisionIdMap.get(item);
                    division = item;

                    binding.relativeDivision.setBackground(ContextCompat.getDrawable(AddTenantActivity.this, R.drawable.edit_text_bg_1));
                    spinner_district();

                } else {
                }
                Log.d("tag4", "division_id : " + present_division_id);

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


    private void spinner_district() {

//        getDistrictData(present_division_id);
        getDistrictData(division);

        spinner_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
                String item = parent.getItemAtPosition(position).toString();
                if (!item.isEmpty() && item != null) {
                    present_district_id = districtIdMap.get(item);
                    district = item;

                    binding.relativeDistrict.setBackground(ContextCompat.getDrawable(AddTenantActivity.this, R.drawable.edit_text_bg_1));
                    spinner_upazila();

                } else {
                }
                Log.d("tag4", "district_id : " + present_district_id);

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


    private void spinner_upazila() {

        getUpozillaData(district);

        spinner_upazila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
                String item = parent.getItemAtPosition(position).toString();
                if (!item.isEmpty() && item != null) {
                    present_upazila_id = upazilaIdMap.get(item);
                    upazila = item;

                    binding.relativeUpazila.setBackground(ContextCompat.getDrawable(AddTenantActivity.this, R.drawable.edit_text_bg_1));

                } else {
                }
                Log.d("tag4", "upazila_id : " + present_upazila_id);

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
    public void getDivisionData() {

        division_list = new ArrayList<String>();
        divisionIdMap = new HashMap<String, String>();

//        List<DivisionDistrictThana> div_list = divisionDistrictThanaViewModel.getDivisionList();

        //        division_list.add("Select Division");
        division_list.add("বিভাগ সিলেক্ট");

        Log.d("tag4", "division_list: " + division_list);
        Log.d("tag4", "div_list: " + div_list);


        divisionDistrictThanaViewModel.getDivisionList().observe(this, dataList -> {
            Log.d("tag4", "dataList: " + dataList);
            div_list = dataList;

            for (DivisionDistrictThana division : div_list) {
                division_list.add(division.division_bn);
                divisionIdMap.put(division.division_bn, division.division);
            }


        });


        dataAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item, division_list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_division.setAdapter(dataAdapter);

    }


    @SuppressLint("CheckResult")
    public void getDistrictData(String division) {

        district_list = new ArrayList<String>();
        districtIdMap = new HashMap<String, String>();

        List<DivisionDistrictThana> dist_list = divisionDistrictThanaViewModel.getDistrictList(division);

//        district_list.add("Select District");
        district_list.add("জেলা সিলেক্ট");

        for (DivisionDistrictThana district : dist_list) {
            district_list.add(district.district_bn);
            districtIdMap.put(district.district_bn, district.district);
        }


        dataAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item, district_list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_district.setAdapter(dataAdapter);

    }


    @SuppressLint("CheckResult")
    public void getUpozillaData(String district) {

        upazila_list = new ArrayList<String>();
        upazilaIdMap = new HashMap<String, String>();


        List<DivisionDistrictThana> upazilas = divisionDistrictThanaViewModel.getThanaList(district);
        ;

//        upazila_list.add("Select Upazilla");
        upazila_list.add("থানা সিলেক্ট");

        for (DivisionDistrictThana upazila1 : upazilas) {
            upazila_list.add(upazila1.thana_bn);
            upazilaIdMap.put(upazila1.thana_bn, upazila1.thana);
        }

        dataAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item, upazila_list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_upazila.setAdapter(dataAdapter);

    }


}