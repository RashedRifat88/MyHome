package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityMonthlyRentPrepareBinding;
import com.egsystembd.myhome.ui.home.house_rent.HouseRentActivity;

public class MonthlyRentPrepareActivity extends AppCompatActivity {

    private ActivityMonthlyRentPrepareBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMonthlyRentPrepareBinding.inflate(getLayoutInflater());
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

        binding.linearAddTenant.setOnClickListener(v -> {
            Intent intent = new Intent(MonthlyRentPrepareActivity.this, AddTenantActivity.class);
            startActivity(intent);
        });


    }


}