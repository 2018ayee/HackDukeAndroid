package com.example.hdandroid.data.model;

public class Schedule {
    public String title;
    public String time;
    public String location;
    public double lat;
    public double lng;

    public Schedule() {
        title = "";
        time = "";
        location = "";
        lat = 36.0014;
        lng = -78.9382;
    }

    public Schedule(String title, String time, String location) {
        this.title = title;
        this.time = time;
        this.location = location;
    }

    public Schedule(String title, String time, String location, double lat, double lng) {
        this.title = title;
        this.time = time;
        this.location = location;
        this.lat = lat;
        this.lng = lng;
    }
}
