package io.nevermore.brvahdemo.model;

/**
 * Created by Lee on 2016/7/5.
 */
public interface INewsModel extends IModel {
    public void getNews(CallBack callBack);
    public void getImage(ImageCallBack callBack,String str);
    public void getStartImage(ImageCallBack callBack);
}
