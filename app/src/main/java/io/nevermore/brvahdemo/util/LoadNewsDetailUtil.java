package io.nevermore.brvahdemo.util;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import io.nevermore.brvahdemo.app.MyApplication;

/**
 * Created by Lee on 2016/7/7.
 */
public class LoadNewsDetailUtil  {
    private RequestQueue requestQueue;
    private String str;

    public LoadNewsDetailUtil() {
        requestQueue = MyApplication.getContext().getRequestQueue();
    }

    public String getJasonRespose(String url){
        StringRequest request = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                str = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
        return str;
    }
}
