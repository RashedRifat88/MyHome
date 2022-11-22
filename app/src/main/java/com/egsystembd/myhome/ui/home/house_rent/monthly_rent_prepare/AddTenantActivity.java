package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityAddTenantBinding;
import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;
import com.egsystembd.myhome.view_model.DivisionDistrictThanaViewModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddTenantActivity extends AppCompatActivity {

    private ActivityAddTenantBinding binding;

    String name = "";
    String date_of_birth = "";
    String bmdc_no = "";
    String mobile_number = "";
    String email = "";
    String facebook_id = "";
    String father_name = "";
    String mother_name = "";
    String job_description = "";
    String nid = "";
    String password = "";
    String password_confirmation = "";
    String passport = "";
    String present_division_id = "";
    String present_district_id = "";
    String present_upazila_id = "";
    String present_address = "";
    String medical_college = "";
    String gender = "";
    String blood_group = "";
    String division = "";
    String district = "";
    String upazila = "";

    ArrayAdapter<String> dataAdapter;
    Spinner spinner_medical_college, spinner_gender, spinner_blood_group, spinner_division, spinner_district, spinner_upazila;
    String medical_college_id;
    List<String> medical_college_list, gender_list, blood_group_list, division_list, district_list, upazila_list;
    HashMap<String, String> medicalCollegeIdMap;
    HashMap<String, String> divisionIdMap;
    HashMap<String, String> districtIdMap;
    HashMap<String, String> upazilaIdMap;

    DivisionDistrictThanaViewModel divisionDistrictThanaViewModel;
    List<DivisionDistrictThana> div_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_add_tenant);
        binding = ActivityAddTenantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        divisionDistrictThanaViewModel = new ViewModelProvider(this).get(DivisionDistrictThanaViewModel.class);

        initComponents();

        spinner_division();


    }

    private void initComponents() {

        spinner_division = findViewById(R.id.spinner_division);
        spinner_district = findViewById(R.id.spinner_district);
        spinner_upazila = findViewById(R.id.spinner_upazila);

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

//        binding.linearAddTenant.setOnClickListener(v -> {
//            Intent intent = new Intent(MonthlyRentPrepareActivity.this, AddTenantActivity.class);
//            startActivity(intent);
//        });


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


        List<DivisionDistrictThana> upazilas = divisionDistrictThanaViewModel.getThanaList(district);;

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