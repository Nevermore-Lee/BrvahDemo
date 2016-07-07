package io.nevermore.brvahdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;

import io.nevermore.brvahdemo.entity.Constants;
import io.nevermore.brvahdemo.entity.News;
import io.nevermore.brvahdemo.R;
import io.nevermore.brvahdemo.util.LoadNewsDetailUtil;

public class NewsDetailActivity extends AppCompatActivity {

    private WebView mWebView;
    private LoadNewsDetailUtil loadNewsDetailUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        Intent intent = getIntent();
        News news = (News) intent.getSerializableExtra("news");
        int id = news.getId();
        mWebView = (WebView)findViewById(R.id.webview);
        setWebView(mWebView);
        mWebView.loadUrl(Constants.URL_BASE_NEWS+id);
    }

    private void setWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
    }
}
