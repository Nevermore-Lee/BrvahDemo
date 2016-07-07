package io.nevermore.brvahdemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import io.nevermore.brvahdemo.entity.News;
import io.nevermore.brvahdemo.presenter.Imp.NewsPresenter;
import io.nevermore.brvahdemo.adapter.QuickAdapter;
import io.nevermore.brvahdemo.R;
import io.nevermore.brvahdemo.view.INewsView;

public class MainActivity extends AppCompatActivity implements INewsView{
    private RecyclerView rView;
    private List<News> newses = new ArrayList<>();
    private NewsPresenter newsPresenter;
    private QuickAdapter quickAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rView = (RecyclerView)findViewById(R.id.rView);
        rView.setLayoutManager(new LinearLayoutManager(this));
        newsPresenter = new NewsPresenter(this);
        newsPresenter.loadNews();

    }

    /**
     * 监听方法
     */

    private void setListeners() {
        quickAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {

            @Override
            public void onItemClick(View view, int i) {
                News news = quickAdapter.getItem(i);
                Intent intent = new Intent(MainActivity.this,NewsDetailActivity.class);
                intent.putExtra("news",news);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setNews(List<News> newses) {
        this.newses = newses;
        quickAdapter = new QuickAdapter(R.layout.item_text,newses,newsPresenter);
        rView.setAdapter(quickAdapter);
        quickAdapter.openLoadAnimation();
        setListeners();
        Log.i("lee","setNews");
    }

    @Override
    public void setStartImage(Bitmap bitmap) {

    }
}
