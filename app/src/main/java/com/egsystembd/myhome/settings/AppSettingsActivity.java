package com.egsystembd.myhome.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.egsystembd.myhome.MainActivity;
import com.egsystembd.myhome.R;
import com.egsystembd.myhome.credential.LoginActivity;
import com.egsystembd.myhome.data.SharedData;
import com.egsystembd.myhome.databinding.ActivitySettingsBinding;
import com.egsystembd.myhome.utils.LanguageManager;

public class AppSettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding binding;
    LanguageManager languageManager;

    LinearLayout linear_change_language;
    TextView tv_language, tv_log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_settings);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initStatusBar();
        initComponemts();
        initMethods();

    }


    private void initMethods() {
//        languageManager = new LanguageManager(this);
        if (SharedData.getLANGUAGE(this) != null) {
            if (SharedData.getLANGUAGE(this).equalsIgnoreCase("bangla")) {
                languageManager = new LanguageManager(this);
                languageManager.updateLocale("bn");
//            recreateActivity();
            } else {
                languageManager = new LanguageManager(this);
                languageManager.updateLocale("en-rUS");
//            recreateActivity();
            }
        }


    }

    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary2, this.getTheme()));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary2));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
        }
    }

    private void initComponemts() {

        linear_change_language = findViewById(R.id.linear_change_language);
        tv_language = findViewById(R.id.tv_language);

        linear_change_language.setOnClickListener(v -> {

            if (tv_language.getText().toString().equalsIgnoreCase("Bangla")) {
                languageManager = new LanguageManager(this);
                languageManager.updateLocale("bn");
                saveLanguage("english");
                recreateActivity();
            } else {
                languageManager = new LanguageManager(this);
                languageManager.updateLocale("en-rUS");
                saveLanguage("bangla");
                recreateActivity();
            }
        });


    }

    private void saveLanguage(String language) {
        SharedData.saveLANGUAGE(this, language);
    }

    private void recreateActivity() {
        finish();
        startActivity(getIntent());
    }


}