package io.nevermore.brvahdemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import io.nevermore.brvahdemo.Model.Imp.NewsModel;
import io.nevermore.brvahdemo.Presenter.Imp.NewsPresenter;
import io.nevermore.brvahdemo.View.INewsView;

public class MainActivity extends AppCompatActivity implements INewsView{
    private RecyclerView rView;
    private List<News> newses = new ArrayList<>();
    private NewsPresenter newsPresenter;
    private ImageView news_iamge;
    private QuickAdapter quickAdapter;
    private ImageView image_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rView = (RecyclerView)findViewById(R.id.rView);
        rView.setLayoutManager(new LinearLayoutManager(this));
        image_background = (ImageView)findViewById(R.id.image_background);
        newsPresenter = new NewsPresenter(this);
        newsPresenter.loadStartImage();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            image_background.setVisibility(View.GONE);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        newsPresenter.loadNews();
    }

    @Override
    public void setNews(List<News> newses) {
        quickAdapter = new QuickAdapter(R.layout.item_text,newses,newsPresenter);
        rView.setAdapter(quickAdapter);
        Log.i("lee","setNews");
    }

    @Override
    public void setStartImage(Bitmap bitmap) {
        image_background.setImageBitmap(bitmap);
    }
}
