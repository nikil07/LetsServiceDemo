package com.androidworks.nikhil.letsservicedemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.androidworks.nikhil.letsservicedemo.model.LocationLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Nikhil on 25-Sep-16.
 */
public class DataStore {

    static Gson gson = new Gson();
    static ArrayList<LocationLog> locationLogs;
    private static DataStore instance;
    private static SharedPreferences sharedPreferences;

    private DataStore() {
        // private constructor to enforce singleton
    }

    public static DataStore getInstance(Context context) {
        if (instance == null) {
            instance = new DataStore();
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
            locationLogs = new ArrayList<>();
        }
        return instance;
    }

    /**
     * to store location logs
     * @param item
     */
    public void storeLocationLogs(LocationLog item) {

        locationLogs = gson.fromJson(sharedPreferences.getString(Constants.SHARED_PREF_LOGS, locationLogs.toString()), new TypeToken<ArrayList<LocationLog>>() {
        }.getType());
        locationLogs.add(item);
        sharedPreferences.edit().putString(Constants.SHARED_PREF_LOGS, gson.toJson(locationLogs)).apply();
    }

    /**
     * to get location logs
     * @return
     */
    public ArrayList<LocationLog> getLocationLogs() {

        return gson.fromJson(sharedPreferences.getString(Constants.SHARED_PREF_LOGS, locationLogs.toString())
                , new TypeToken<ArrayList<LocationLog>>() {
                }.getType());
    }
}
