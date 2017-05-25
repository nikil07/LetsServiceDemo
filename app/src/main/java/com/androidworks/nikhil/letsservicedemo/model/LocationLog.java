package com.androidworks.nikhil.letsservicedemo.model;

/**
 * Created by Nikhil on 24-May-17.
 */
public class LocationLog {

    private double latitude;
    private double longitude;
    private String timeStamp;

    public LocationLog() {
    }

    public LocationLog(double latitude, double longitude, String timeStamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeStamp = timeStamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
