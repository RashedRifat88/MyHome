package com.egsystembd.myhome;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.egsystembd.myhome.data.SharedData;
import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;
import com.egsystembd.myhome.settings.AppSettingsActivity;
import com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare.AddTenantActivity;
import com.egsystembd.myhome.utils.LanguageManager;
import com.egsystembd.myhome.view_model.DivisionDistrictThanaViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.egsystembd.myhome.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
//    LanguageManager languageManager;

    static TextView tv_user_name, tv_user_profile_completion_status;
    View headerView;
    static ImageView iv_profile_image;
    String userName;
    LinearLayout linear1, linear10;
    DrawerLayout drawerLayout;
    ImageView iv_menu1;
    ActionBarDrawerToggle toggle;
    NavigationView navigationViewDrawer;
    Toolbar toolbar;

    DivisionDistrictThanaViewModel divisionDistrictThanaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_emergency_service_call, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        initStatusBar();
        initNavigationMenu();

        divisionDistrictThanaViewModel = new ViewModelProvider(this).get(DivisionDistrictThanaViewModel.class);
//        loadDivisionData();

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


    private void initNavigationMenu() {

        iv_menu1 = findViewById(R.id.iv_menu1);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationViewDrawer = findViewById(R.id.nav_view_drawer);
        navigationViewDrawer.setNavigationItemSelectedListener(this);

        navigationViewDrawer.setItemIconTintList(null);

        iv_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

//        navigationViewDrawer.getMenu().getItem(0).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(1).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(2).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(3).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(4).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(5).setActionView(R.layout.layout_arrow_right);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


        headerView = navigationViewDrawer.getHeaderView(0);
        tv_user_profile_completion_status = headerView.findViewById(R.id.tv_user_profile_completion_status);
        tv_user_name = headerView.findViewById(R.id.tv_user_name);
        iv_profile_image = headerView.findViewById(R.id.iv_profile_image);
        linear10 = headerView.findViewById(R.id.linear10);


//        if (SharedData.getUserName(this) == null) {
//            tv_user_profile_completion_status.setText("");
//        } else {
//            tv_user_profile_completion_status.setText(SharedData.getUserProfileCompletionPercent(this));
//        }
//
//        if (SharedData.getUserName(this) == null) {
//            tv_user_name.setText("User Name");
//        } else {
//            tv_user_name.setText(SharedData.getUserName(this));
//        }


//        String pro_pic = SharedData.getUserImage(this);
//        Log.d("tag222", "pro_pic: " + pro_pic);
//        if (pro_pic == null) {
//            iv_profile_image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_profile));
//        } else if (pro_pic.equalsIgnoreCase("null")) {
//            iv_profile_image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_profile));
//        } else if (pro_pic.equalsIgnoreCase("")) {
//            iv_profile_image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_profile));
//        } else {
//            Log.d("tag1000", "pro_pic Glide: " + pro_pic);
//            Glide.with(this).load(pro_pic).placeholder(R.drawable.ic_profile).into(iv_profile_image);
//
//        }


//        linear1 = findViewById(R.id.linear1);
//        linear10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
//
//                if (userName == null) {
//                    intent.putExtra("user_name", "User Name");
//                } else {
//                    intent.putExtra("user_name", userName);
//                }
//
//                startActivityForResult(intent, 201);
//            }
//        });
//

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        if (item.getItemId() == R.id.menu_add_tenant) {
            Intent intent = new Intent(MainActivity.this, AddTenantActivity.class);
            intent.putExtra("from_where", "main_drawer");
            startActivity(intent);
        }

        if (item.getItemId() == R.id.menu_settings) {

            Intent intent = new Intent(MainActivity.this, AppSettingsActivity.class);
//            String menu_name = "1";
//            intent.putExtra("menuName", menu_name);
            startActivity(intent);

        }

        if (item.getItemId() == R.id.menu_invite_others) {

//            Intent intent = new Intent(MainActivity.this, InviteOthersActivity.class);
//            String menu_name = "1";
//            intent.putExtra("menuName", menu_name);
//            startActivity(intent);

        }


        if (item.getItemId() == R.id.menu_rating) {
//            rateApp();
        }


        if (item.getItemId() == R.id.nav_logout) {

//            SharedData.saveTOKEN(MainActivity.this, "");
//            finish();
        }

        return false;

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d("tagklkl", "OnResume called");

//        if (SharedData.getLANGUAGE(this) != null) {
//            if (SharedData.getLANGUAGE(this).equalsIgnoreCase("bangla")) {
//                languageManager = new LanguageManager(this);
//                languageManager.updateLocale("bn");
////                recreateActivity();
//            } else {
//                languageManager = new LanguageManager(this);
//                languageManager.updateLocale("en-rUS");
////                recreateActivity();
//            }
//        }


    }

    private void recreateActivity() {
        finish();
        startActivity(getIntent());
    }



    private void loadDivisionData() {

        JSONArray divisions = loadJSONArray_division(this);

        try {
            for (int i = 0; i < divisions.length(); i++) {
                JSONObject division = divisions.getJSONObject(i);

                String division_name = division.getString("name");
                String division_name_bn = division.getString("bn_name");

                JSONArray districtArray = division.getJSONArray("districts");

                Log.d("tagTTT", "division_name: " +division_name);

                for (int j = 0; j < districtArray.length(); j++) {

                    JSONObject district = districtArray.getJSONObject(j);

                    String district_name = district.getString("name");
                    String district_name_bn = district.getString("bn_name");
                    Log.d("tagTTT", "district_name: " +district_name);


                    JSONArray thanaArray = district.getJSONArray("upazilas");


                    for (int k = 0; k < thanaArray.length(); k++) {

                        JSONObject thana = thanaArray.getJSONObject(k);

                        String thana_name = thana.getString("name");
                        String thana_name_bn = thana.getString("bn_name");
                        Log.d("tagTTT", "thana_name: " +thana_name);

                        DivisionDistrictThana obj1 = new DivisionDistrictThana();
                        obj1.division = division_name;
                        obj1.division_bn = division_name_bn;
                        obj1.district = district_name;
                        obj1.district_bn = district_name_bn;
                        obj1.thana = thana_name;
                        obj1.thana_bn = thana_name_bn;

                        divisionDistrictThanaViewModel.insertDivisionDistrictThana(obj1);

                    }

                }


//                Toast.makeText(this, "DivisionDistrictThana created successfully", Toast.LENGTH_SHORT).show();


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public static JSONArray loadJSONArray_division(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = context.getResources().openRawResource(R.raw.division_district_thana);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            return jsonObject.getJSONArray("division_list");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }





}