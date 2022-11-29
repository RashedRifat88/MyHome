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
import com.egsystembd.myhome.databinding.ActivityTenantEditBinding;
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

public class TenantEditActivity extends AppCompatActivity {

    private ActivityTenantEditBinding binding;

    String tenant_id = "";
    int deed_id;

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
    Tenant tenant;
    Deed deed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_tenant_edit);
        binding = ActivityTenantEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tenant_id = getIntent().getStringExtra("tenant_id");

        divisionDistrictThanaViewModel = new ViewModelProvider(this).get(DivisionDistrictThanaViewModel.class);
        tenantViewModel = new ViewModelProvider(this).get(TenantViewModel.class);
        deedViewModel = new ViewModelProvider(this).get(DeedViewModel.class);
        rentCollectionViewModel = new ViewModelProvider(this).get(RentCollectionViewModel.class);

        tenant = tenantViewModel.getTenantById(Integer.parseInt(tenant_id));
        deed = deedViewModel.getDeedByTenantId(Integer.parseInt(tenant_id));


        initComponents();
        loadPreviousData();

        spinner_division();
        loadCalender_contract_start_date();


    }

    private void loadPreviousData() {

        deed_id = deed.id;

        this.name = tenant.name;
        this.mobile_number = tenant.phone;
        this.nid = tenant.nid;
        this.division = tenant.devision;
        this.district = tenant.district;
        this.upazila = tenant.thana;
        this.post_office = tenant.post_office;
        this.village = tenant.area;

        this.flat_no = deed.flat_no;
        this.monthly_rent = String.valueOf(deed.monthly_rent);
        this.service_charge = String.valueOf(deed.service_charge);
        this.total_advance = String.valueOf(deed.total_advance);
        this.monthly_advance_deduction = String.valueOf(deed.monthly_advance_deduction);
        this.contract_start_date = deed.contract_start_date;
        this.contract_duration = deed.contract_duration;
        this.contract_validity = String.valueOf(deed.validity);

        binding.etTenantName.setText(name);
        binding.etTenantMobile.setText(mobile_number);
        binding.etTenantNid.setText(nid);
        binding.etPostOffice.setText(post_office);
        binding.etVillage.setText(village);
        binding.etFlatNo.setText(flat_no);
        binding.etMonthlyRent.setText(monthly_rent);
        binding.etServiceCharge.setText(service_charge);
        binding.etTotalAdvance.setText(total_advance);
        binding.etMonthlyAdvanceDeduction.setText(monthly_advance_deduction);
        binding.etContractDuration.setText(contract_duration);
        binding.tvContractStartDate.setText(deed.contract_start_date);


    }

    private void initComponents() {

        spinner_division = findViewById(R.id.spinner_division);
        spinner_district = findViewById(R.id.spinner_district);
        spinner_upazila = findViewById(R.id.spinner_upazila);

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.linearSave.setOnClickListener(v -> {
//            Intent intent = new Intent(TenantEditActivity.this, TenantEditActivity.class);
//            startActivity(intent);
            editTenant();
        });


    }


    private void editTenant() {
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
            this.name = binding.etTenantName.getText().toString();
        }


        if (binding.etTenantMobile.getText().toString().isEmpty()) {
            binding.etTenantMobile.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.mobile_number = binding.etTenantMobile.getText().toString();
        }


        if (binding.etTenantNid.getText().toString().isEmpty()) {
            binding.etTenantNid.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.nid = binding.etTenantNid.getText().toString();
        }


//        if (this.division.equalsIgnoreCase("বিভাগ সিলেক্ট")) {
//            binding.relativeDivision.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
//        } else {
//            division = this.division;
//        }
//
//        Log.d("this.division", "this.division: " + this.division);
//
//
//        if (this.district.equalsIgnoreCase("জেলা সিলেক্ট")) {
//            binding.relativeDistrict.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
//        } else {
//            district = this.district;
//        }
//
//        Log.d("this.division", "this.district: " + this.district);
//
//
//        if (this.upazila.equalsIgnoreCase("থানা সিলেক্ট")) {
//            binding.relativeUpazila.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
//        } else {
//            upazila = this.upazila;
//        }


        if (binding.etPostOffice.getText().toString().isEmpty()) {
            binding.etPostOffice.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.post_office = binding.etPostOffice.getText().toString();
        }


        if (binding.etVillage.getText().toString().isEmpty()) {
            binding.etVillage.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.village = binding.etVillage.getText().toString();
        }


        if (binding.etFlatNo.getText().toString().isEmpty()) {
            binding.etFlatNo.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.flat_no = binding.etFlatNo.getText().toString();
        }


        if (binding.etMonthlyRent.getText().toString().isEmpty()) {
            binding.etMonthlyRent.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.monthly_rent = binding.etMonthlyRent.getText().toString();
        }


        if (binding.etServiceCharge.getText().toString().isEmpty()) {
            binding.etServiceCharge.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.service_charge = binding.etServiceCharge.getText().toString();
        }


        if (binding.etTotalAdvance.getText().toString().isEmpty()) {
            binding.etTotalAdvance.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.total_advance = binding.etTotalAdvance.getText().toString();
        }


        if (binding.etMonthlyAdvanceDeduction.getText().toString().isEmpty()) {
            binding.etMonthlyAdvanceDeduction.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.monthly_advance_deduction = binding.etMonthlyAdvanceDeduction.getText().toString();
        }


        if (this.contract_start_date == null || this.contract_start_date.isEmpty()) {
            binding.linearContractStartDate.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500));
        } else {
            this.contract_start_date = this.contract_start_date;
        }


        if (binding.etContractDuration.getText().toString().isEmpty()) {
            binding.etContractDuration.setError("দয়া করে ঘরটি পূরণ করুন");
        } else {
            this.contract_duration = binding.etContractDuration.getText().toString();
        }



        Log.d("tag4", "this.name: " + this.name);
        Log.d("tag4", "this.mobile_number: " + this.mobile_number);
        Log.d("tag4", "this.nid: " + this.nid);
        Log.d("tag4", "this.division: " + this.division);
        Log.d("tag4", "this.district: " + this.district);
        Log.d("tag4", "this.upazila: " + this.upazila);
        Log.d("tag4", "this.post_office: " + this.post_office);
        Log.d("tag4", "this.village: " + this.village);
        Log.d("tag4", "this.flat_no: " + this.flat_no);
        Log.d("tag4", "this.monthly_rent: " + this.monthly_rent);
        Log.d("tag4", "this.service_charge: " + this.service_charge);
        Log.d("tag4", "this.total_advance: " + this.total_advance);
        Log.d("tag4", "this.monthly_advance_deduction: " + this.monthly_advance_deduction);
        Log.d("tag4", "this.contract_start_date: " + this.contract_start_date);
        Log.d("tag4", "this.contract_duration: " + this.contract_duration);


        if (this.name.isEmpty() || this.mobile_number.isEmpty() || this.nid.isEmpty() || this.division.equalsIgnoreCase("বিভাগ সিলেক্ট") ||
                this.district.equalsIgnoreCase("জেলা সিলেক্ট") || this.upazila.equalsIgnoreCase("থানা সিলেক্ট") ||
                this.post_office.isEmpty() || this.village.isEmpty() || this.flat_no.isEmpty() || this.monthly_rent.isEmpty() || this.service_charge.isEmpty() || this.total_advance.isEmpty() ||
                this.monthly_advance_deduction.isEmpty() || this.contract_start_date.isEmpty() || this.contract_duration.isEmpty()) {

            Toast.makeText(this, "দয়া করে সবগুলো ঘর পূরণ করুন", Toast.LENGTH_SHORT).show();

        } else {

            Tenant obj1 = new Tenant();
            obj1.id = Integer.parseInt(tenant_id);
            obj1.name = this.name;
            obj1.phone = this.mobile_number;
            obj1.nid = this.nid;
            obj1.devision = this.division;
            obj1.district = this.district;
            obj1.thana = this.upazila;
            obj1.post_office = this.post_office;
            obj1.area = this.village;

            tenantViewModel.updateTenant(obj1);

            Deed obj2 = new Deed();
            obj2.id = deed_id;
            obj2.tenant_id = Integer.parseInt(tenant_id);
            obj2.flat_no = this.flat_no;
            obj2.monthly_rent = Float.parseFloat(this.monthly_rent);
            obj2.service_charge = Float.parseFloat(this.service_charge);
            obj2.total_advance = Float.parseFloat(this.total_advance);
            obj2.monthly_advance_deduction = Float.parseFloat(this.monthly_advance_deduction.toString());
            obj2.contract_start_date = this.contract_start_date.toString();
            obj2.contract_duration = this.contract_duration;

            deedViewModel.updateDeed(obj2);




            Log.d("tag4", "monthly_advance_deduction: " + monthly_advance_deduction.toString());
            Log.d("tag4", "contract_start_date: " + contract_start_date.toString());


            Toast.makeText(this, "ভাড়াটিয়া সফলভাবে এডিট হয়েছে", Toast.LENGTH_SHORT).show();
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
                        TenantEditActivity.this,
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
//                Toast.makeText(TenantEditActivity.this, "contract_start_date:" + contract_start_date, Toast.LENGTH_SHORT).show();

                binding.linearContractStartDate.setBackgroundColor(ContextCompat.getColor(TenantEditActivity.this, R.color.transparent));
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

                    binding.relativeDivision.setBackground(ContextCompat.getDrawable(TenantEditActivity.this, R.drawable.edit_text_bg_1));
                    spinner_district();

                    if (division.equalsIgnoreCase("বিভাগ সিলেক্ট")){
                        division = tenant.devision;
                    }

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
                division = tenant.devision;
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

                    binding.relativeDistrict.setBackground(ContextCompat.getDrawable(TenantEditActivity.this, R.drawable.edit_text_bg_1));
                    spinner_upazila();

                    if (district.equalsIgnoreCase("জেলা সিলেক্ট")){
                        district = tenant.district;
                    }

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
                district = tenant.district;
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

                    binding.relativeUpazila.setBackground(ContextCompat.getDrawable(TenantEditActivity.this, R.drawable.edit_text_bg_1));

                    if (upazila.equalsIgnoreCase("থানা সিলেক্ট")){
                        upazila = tenant.thana;
                    }

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
                upazila = tenant.thana;
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