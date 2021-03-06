package io.nevermore.brvahdemo.model.Imp;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.nevermore.brvahdemo.app.MyApplication;
import io.nevermore.brvahdemo.entity.Constants;
import io.nevermore.brvahdemo.model.INewsModel;
import io.nevermore.brvahdemo.entity.News;
import io.nevermore.brvahdemo.util.JsonParser;

/**
 * Created by Lee on 2016/7/5.
 */
public class NewsModel implements INewsModel {
    private List<News> newses;
    private RequestQueue requestQueue;

    public NewsModel() {
        newses = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(MyApplication.getContext());
    }

    @Override
    public  void getNews(final CallBack callBack){
        String url = Constants.URL_NEWS_LIST_LATEST;
        StringRequest request = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("stories");
                    String date = object.getString("date");
                    newses = JsonParser.parserNewsList(array);
                    for (News news:newses) {
                        news.setDate(date);
                    }
                    callBack.onSuccess(newses);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.toString());
            }
        });
        requestQueue.add(request);
    }

    @Override
    public void getImage(final ImageCallBack callBack, String str) {
        String string = fixUrl(str);
        ImageRequest request = new ImageRequest(string, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                callBack.onSuccess(response);
            }
        }, 88, 88, ImageView.ScaleType.FIT_XY,Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("lee","loadBitmap"+error.toString());
            }
        });
        requestQueue.add(request);
    }

    @Override
    public void getStartImage(final ImageCallBack callBack) {
        String url = Constants.URL_START_IMAGE;
        StringRequest request = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    response = object.getString("img");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ImageRequest imageRequest = new ImageRequest(response, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {

                        Log.i("lee","getStartImage"+response.toString());
                        callBack.onSuccess(response);

                    }
                }, 1080, 1766, ImageView.ScaleType.FIT_XY ,Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("lee","getStartImage"+error.toString());
                    }
                });
                requestQueue.add(imageRequest);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }

    /**
     * 解决url中的反斜杠问题
     * @param string
     * @return
     */

    private static String fixUrl(String string) {
        string = string.substring(2, string.length() - 2);
        String sub;
        String url;
        sub = string.substring(0, 5);
        url = sub + "//";
        sub = string.substring(9, 23);
        url = url + sub + "/";
        sub = string.substring(25);
        url = url + sub;
        Log.i("tedu", "url=" + url);
        return url;
    }

}
