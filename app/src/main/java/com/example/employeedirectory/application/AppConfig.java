package com.example.employeedirectory.application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;


import java.net.URISyntaxException;


@SuppressLint("CommitPrefEdits")
public class AppConfig extends MultiDexApplication {

    private static AppConfig appInstance;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedPreferencesEditor;
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mctx) {
        mContext = mctx;
    }

    public static AppConfig getAppInstance() {
        if (appInstance == null)
            throw new IllegalStateException("The application is not created yet!");
        return appInstance;
    }

    public static SharedPreferences.Editor getApplicationPreferenceEditor() {
        return sharedPreferencesEditor;
    }

    public static SharedPreferences getApplicationPreference() {
        return sharedPreferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        sharedPreferencesEditor = sharedPreferences.edit();
        setContext(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


}
