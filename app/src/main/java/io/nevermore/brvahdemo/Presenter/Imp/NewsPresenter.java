package io.nevermore.brvahdemo.Presenter.Imp;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import java.util.List;

import io.nevermore.brvahdemo.Constants;
import io.nevermore.brvahdemo.Model.IModel;
import io.nevermore.brvahdemo.Model.INewsModel;
import io.nevermore.brvahdemo.Model.Imp.NewsModel;
import io.nevermore.brvahdemo.News;
import io.nevermore.brvahdemo.Presenter.INewsPresenter;
import io.nevermore.brvahdemo.View.INewsView;

/**
 * Created by Administrator on 2016/7/6.
 */
public class NewsPresenter implements INewsPresenter {

    private INewsView view;
    private INewsModel model;

    public NewsPresenter(INewsView view) {
        this.view = view;
        this.model = new NewsModel();
    }

    @Override
    public void loadNews() {
        model.getNews(new IModel.CallBack() {
            @Override
            public void onSuccess(List<News> newses) {
                view.setNews(newses);
            }

            @Override
            public void onError(String errorMsg) {
                Log.i("lee",errorMsg);
            }
        });
    }

    @Override
    public void loadImage(final ImageView imageView, String url) {
        model.getImage(new IModel.ImageCallBack() {
            @Override
            public void onSuccess(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            public void onError(String errorMsg) {

            }
        },url);

    }

    /**
     * 加载开始界面图片
     */

    @Override
    public void loadStartImage() {
        model.getStartImage(new IModel.ImageCallBack() {
            @Override
            public void onSuccess(Bitmap bitmap) {
                view.setStartImage(bitmap);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
