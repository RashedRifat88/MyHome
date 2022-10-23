package com.egsystembd.myhome.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LanguageManager {

    Context context;

    public LanguageManager(Context context) {
        this.context = context;
    }

    public void updateLocale(String code){

        Locale locale = new Locale(code);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
//        configuration.locale = locale;
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

    }

}
