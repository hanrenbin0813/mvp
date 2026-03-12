package com.example.myapplication.common;

import android.app.Application;

import com.example.myapplication.utils.App;

public class MyApplication extends Application {
    private App app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=new App();
        app.onCreate(this);
    }
}
