package io.nevermore.brvahdemo.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Lee on 2016/7/5.
 */
public class MyApplication extends Application {
    private static MyApplication context;
    private RequestQueue requestQueue ;
    @Override
    public void onCreate() {
        context = this;
        requestQueue = Volley.newRequestQueue(MyApplication.getContext());
        super.onCreate();
    }
    public static  MyApplication getContext(){
        return context;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
