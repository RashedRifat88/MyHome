package com.egsystembd.myhome.credential;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.egsystembd.myhome.MainActivity;
import com.egsystembd.myhome.R;
import com.egsystembd.myhome.utils.LanguageManager;

public class LoginActivity extends AppCompatActivity {

    LanguageManager languageManager;

    LinearLayout linear_change_language;
    TextView tv_language, tv_log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initStatusBar();
        initComponemts();
        initMethods();

    }

    private void initMethods() {
        languageManager = new LanguageManager(this);
//        if (tv_language.getText().toString().equalsIgnoreCase("Bangla")) {
//            languageManager.updateLocale("bn-rBD");
////        saveLanguage("english");
//        } else {
//            languageManager.updateLocale("en-rUS");
////        saveLanguage("english");
//        }

    }

    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gradient3, this.getTheme()));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.gradient3));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
        }
    }

    private void initComponemts() {

        linear_change_language = findViewById(R.id.linear_change_language);
        tv_language = findViewById(R.id.tv_language);
        tv_log_in = findViewById(R.id.tv_log_in);

        linear_change_language.setOnClickListener(v -> {

            if (tv_language.getText().toString().equalsIgnoreCase("Bangla")) {
                languageManager = new LanguageManager(this);
                languageManager.updateLocale("bn");
                recreateActivity();
//        saveLanguage("english");
                recreateActivity();
            } else {
                languageManager = new LanguageManager(this);
                languageManager.updateLocale("en-rUS");
                recreateActivity();
            }
        });

        tv_log_in.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void recreateActivity() {
        finish();
        startActivity(getIntent());
    }
}