package com.androidworks.nikhil.letsservicedemo.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by nikhilkumar_s on 6/1/2016.
 */
public class LocationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, LocationService.class);
        context.startService(service);
    }
}
