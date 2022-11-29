package com.egsystembd.myhome.ui.home.house_rent.tenant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityTenantDetailsBinding;
import com.egsystembd.myhome.model.house_rent.Deed;
import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;
import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.view_model.DeedViewModel;
import com.egsystembd.myhome.view_model.DivisionDistrictThanaViewModel;
import com.egsystembd.myhome.view_model.RentCollectionViewModel;
import com.egsystembd.myhome.view_model.TenantViewModel;

import java.util.HashMap;
import java.util.List;

public class TenantDetailsActivity extends AppCompatActivity {


    private ActivityTenantDetailsBinding binding;

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
        //        setContentView(R.layout.activity_tenant_details);
        binding = ActivityTenantDetailsBinding.inflate(getLayoutInflater());
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
        binding.etDivision.setText(division);
        binding.etDistrict.setText(district);
        binding.etThana.setText(upazila);


    }

    private void initComponents() {


        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

//        binding.linearEdit.setOnClickListener(v -> {
//            finish();
//        });

        binding.linearEdit.setOnClickListener(v -> {
            Intent intent = new Intent(TenantDetailsActivity.this, TenantEditActivity.class);
            intent.putExtra("tenant_id", tenant_id);
            startActivity(intent);
        });


    }


}

