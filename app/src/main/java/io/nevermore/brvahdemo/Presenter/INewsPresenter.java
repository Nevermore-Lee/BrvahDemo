package io.nevermore.brvahdemo.Presenter;

import android.widget.ImageView;

/**
 * Created by Lee on 2016/7/6.
 */
public interface INewsPresenter extends IPresenter {
    public  void loadNews();
    public  void loadImage(ImageView imageView,String url);
    public  void loadStartImage();
}
