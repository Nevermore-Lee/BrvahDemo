package io.nevermore.brvahdemo.Model;

import android.graphics.Bitmap;

import java.util.List;

import io.nevermore.brvahdemo.News;

/**
 * Created by Lee on 2016/7/5.
 */
public interface IModel {
    public  interface  CallBack{
        void onSuccess(List<News> newses);
        void onError(String errorMsg);
    }
    public  interface  ImageCallBack{
        void onSuccess(Bitmap bitmap);
        void onError(String errorMsg);
    }
}
