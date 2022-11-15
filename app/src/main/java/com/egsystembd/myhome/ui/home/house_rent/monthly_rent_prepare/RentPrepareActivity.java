package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.egsystembd.myhome.databinding.ActivityRentPrepareBinding;

public class RentPrepareActivity extends AppCompatActivity {

    private ActivityRentPrepareBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fare_prepare);

        binding = ActivityRentPrepareBinding.inflate(getLayoutInflater());
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