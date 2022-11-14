package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityAddTenantBinding;

public class AddTenantActivity extends AppCompatActivity {

    private ActivityAddTenantBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTenantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_add_tenant);




    }
}