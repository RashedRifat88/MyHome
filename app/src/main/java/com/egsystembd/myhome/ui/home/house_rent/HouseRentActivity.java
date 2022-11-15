package com.egsystembd.myhome.ui.home.house_rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityHouseRentBinding;
import com.egsystembd.myhome.databinding.ActivityMainBinding;
import com.egsystembd.myhome.ui.home.house_rent.advance_rent.AdvanceRentActivity;
import com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare.MonthlyRentPrepareActivity;
import com.egsystembd.myhome.ui.home.house_rent.rent_collection.RentCollectionActivity;
import com.egsystembd.myhome.ui.home.house_rent.total_rent_collection.TotalRentCollectionActivity;

public class HouseRentActivity extends AppCompatActivity {

    private ActivityHouseRentBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHouseRentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initStatusBar();
        initComponents();
    }


    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary2, this.getTheme()));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary2));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
        }
    }


    private void initComponents() {
        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.cardHouseRent.setOnClickListener(v -> {
            Intent intent = new Intent(HouseRentActivity.this, MonthlyRentPrepareActivity.class);
            startActivity(intent);
        });


        binding.cardRentCollection.setOnClickListener(v -> {
            Intent intent = new Intent(HouseRentActivity.this, RentCollectionActivity.class);
            startActivity(intent);
        });


        binding.cardTotalRentCollection.setOnClickListener(v -> {
            Intent intent = new Intent(HouseRentActivity.this, TotalRentCollectionActivity.class);
            startActivity(intent);
        });


        binding.cardAdvanceRent.setOnClickListener(v -> {
            Intent intent = new Intent(HouseRentActivity.this, AdvanceRentActivity.class);
            startActivity(intent);
        });


    }


}