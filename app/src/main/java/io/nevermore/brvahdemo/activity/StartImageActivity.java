package io.nevermore.brvahdemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import io.nevermore.brvahdemo.R;
import io.nevermore.brvahdemo.entity.News;
import io.nevermore.brvahdemo.presenter.Imp.NewsPresenter;
import io.nevermore.brvahdemo.view.INewsView;

public class StartImageActivity extends AppCompatActivity implements INewsView{

    private ImageView image_background;
    private NewsPresenter newsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_image);
        image_background = (ImageView)findViewById(R.id.image_background);
        newsPresenter = new NewsPresenter(this);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            image_background.setVisibility(View.GONE);
                            Intent intent = new Intent(StartImageActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        newsPresenter.loadStartImage();
    }


    @Override
    public void setNews(List<News> newses) {

    }

    @Override
    public void setStartImage(Bitmap bitmap) {
        image_background.setImageBitmap(bitmap);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
