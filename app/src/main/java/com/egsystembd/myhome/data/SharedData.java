package com.egsystembd.myhome.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedData {

    public static final String DEVICE_ID = "device_id";
    public static final String MORAL_REPORT_ENABLED = "night_node_enabled";

    public static void saveDEVICE_ID(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(DEVICE_ID, value);
        editor.commit();
    }

    public static String getDEVICE_ID(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(DEVICE_ID, null);
    }


    public static void saveMORAL_REPORT_ENABLED(Context context, boolean value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(MORAL_REPORT_ENABLED, value);
        editor.commit();
    }

    public static Boolean getMORAL_REPORT_ENABLED(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(MORAL_REPORT_ENABLED, false);
    }


}
