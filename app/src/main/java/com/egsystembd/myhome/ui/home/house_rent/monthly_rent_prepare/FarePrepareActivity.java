package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.egsystembd.myhome.databinding.ActivityFarePrepareBinding;

public class FarePrepareActivity extends AppCompatActivity {

    private ActivityFarePrepareBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fare_prepare);

        binding = ActivityFarePrepareBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}