package com.example.my_test6.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.my_test6.R;
import com.example.my_test6.ui.user.web;

public class Item_web extends AppCompatActivity {
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_web);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        String s = getIntent().getStringExtra("url");
        web = findViewById(R.id.item_webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setUseWideViewPort(true); //将图片调整到适合webview的大小
        web.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        web.setWebViewClient(new MyWebViewClient());
        web.loadUrl(s);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }
}