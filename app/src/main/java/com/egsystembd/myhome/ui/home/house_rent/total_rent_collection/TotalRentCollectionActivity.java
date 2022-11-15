package com.egsystembd.myhome.ui.home.house_rent.total_rent_collection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityRentCollectionBinding;
import com.egsystembd.myhome.databinding.ActivityTotalRentCollectionBinding;
import com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare.AddTenantActivity;
import com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare.MonthlyRentPrepareActivity;

public class TotalRentCollectionActivity extends AppCompatActivity {

    private ActivityTotalRentCollectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_total_rent_collection);
        binding = ActivityTotalRentCollectionBinding.inflate(getLayoutInflater());
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