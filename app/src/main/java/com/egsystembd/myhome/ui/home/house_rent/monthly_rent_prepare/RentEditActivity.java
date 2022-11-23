package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityRentEditBinding;


public class RentEditActivity extends AppCompatActivity {


    private ActivityRentEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rent_edit);

        binding = ActivityRentEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initComponents();

    }


    private void initComponents() {
        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

//        binding.linearAddTenant.setOnClickListener(v -> {
//            Intent intent = new Intent(MonthlyRentPrepareActivity.this, AddTenantActivity.class);
//            startActivity(intent);
//        });


    }

}