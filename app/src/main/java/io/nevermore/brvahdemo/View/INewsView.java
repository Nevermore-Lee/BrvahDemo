package io.nevermore.brvahdemo.view;


import android.graphics.Bitmap;

import java.util.List;

import io.nevermore.brvahdemo.entity.News;

/**
 * Created by Administrator on 2016/7/6.
 */
public interface INewsView extends IView {
    public  void setNews(List<News>newses);
    public  void setStartImage(Bitmap bitmap);
}
