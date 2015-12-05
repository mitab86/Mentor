package com.example.mitab.mentor;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Mitab on 12/3/2015.
 */
public class VolleySingleton {
    private static VolleySingleton sInstance=null;

    private VolleySingleton(){
        mRequestQueue= Volley.newRequestQueue();
        //volley
    }
    public static VolleySingleton getsInstance(){
        if (sInstance == null)
        {
            sInstance=new VolleySingleton();
        }
        return sInstance;
    }
    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
}
