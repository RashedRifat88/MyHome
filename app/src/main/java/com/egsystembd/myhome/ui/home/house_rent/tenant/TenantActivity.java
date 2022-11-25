package com.egsystembd.myhome.ui.home.house_rent.tenant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.ActivityTenantBinding;
import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare.MonthlyRentPrepareActivity;
import com.egsystembd.myhome.ui.home.house_rent.tenant.adapter.TenantAdapter;
import com.egsystembd.myhome.view_model.TenantViewModel;

import java.util.List;

public class TenantActivity extends AppCompatActivity {


    private ActivityTenantBinding binding;

    TenantViewModel tenantViewModel;
    TenantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tenant);
        binding = ActivityTenantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initStatusBar();
        initComponents();

        tenantViewModel = new ViewModelProvider(this).get(TenantViewModel.class);
        tenantViewModel.getAllTenant.observe(this, tenantList -> {
            setAdapter(tenantList);
//            filteredNoteList = notes;
        });
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
            Intent intent = new Intent(TenantActivity.this, AddTenantActivity.class);
            startActivity(intent);
        });


    }

    private void setAdapter(List<Tenant> tenantList) {

        Log.d("tag666", "note number: " + tenantList.size());
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter = new TenantAdapter(this, tenantList);
        binding.recyclerView.setAdapter(adapter);
    }



}