package com.egsystembd.myhome.ui.home.house_rent.rent_collection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.egsystembd.myhome.databinding.ActivityRentCollectionBinding;

public class RentCollectionActivity extends AppCompatActivity {

    private ActivityRentCollectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rent_collection);
        binding = ActivityRentCollectionBinding.inflate(getLayoutInflater());
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