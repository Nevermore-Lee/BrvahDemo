package io.nevermore.brvahdemo.adapter;


import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;


import java.util.List;

import io.nevermore.brvahdemo.R;
import io.nevermore.brvahdemo.entity.News;
import io.nevermore.brvahdemo.presenter.Imp.NewsPresenter;

/**
 * Created by Lee on 2016/7/5.
 */
public class QuickAdapter extends com.chad.library.adapter.base.BaseQuickAdapter<News> {

    private Bitmap bitmap;
    private NewsPresenter presenter;


    public QuickAdapter(int layoutResId, List<News> data,NewsPresenter presenter) {
        super(layoutResId, data);
        this.presenter = presenter;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final News news) {
        String str = news.getImage();
        presenter.loadImage((ImageView) baseViewHolder.getView(R.id.news_image),str);
        baseViewHolder.setText(R.id.news_title,news.getTitle()).setImageBitmap(R.id.news_image,bitmap);
    }

}
