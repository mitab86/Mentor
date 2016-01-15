package com.example.mitab.mentor.Movies.Pages;

import android.app.Application;
import android.content.Context;

/**
 * Created by Mitab on 1/12/2016.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;
    public static final String API_KEY="9a267e5d80e736fc4a38b7fdebfc11ea";

    @Override
    public void onCreate(){
        super.onCreate();
        sInstance=this;
    }
    public static MyApplication getsInstance(){
        return sInstance;
    }
    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}
