package com.example.my_test6.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.example.my_test6.R;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        getSupportActionBar().hide();
        WebView webview = findViewById(R.id.login_WebView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setUseWideViewPort(true); //将图片调整到适合webview的大小
        webview.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webview.setWebViewClient(new MyWebViewClient());
        StringBuilder builder = new StringBuilder();
        builder.append("client_id=").append("8ab24367-91d6-4c19-9846-121909a0e01f").append("&")
                .append("scope=").append("openid profile CnBlogsApi").append("&")
                .append("response_type=").append("code id_token").append("&")
                .append("redirect_uri=").append("https://oauth.cnblogs.com/auth/callback").append("&")
                .append("state=").append("cnblogs.com").append("&")
                .append("nonce=").append("cnblogs.com");
        String postData = builder.toString();
        String url = "https://oauth.cnblogs.com/connect/authorize";
        webview.postUrl(url, postData.getBytes());
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if(request.getUrl().toString().substring(0,39).equals("https://oauth.cnblogs.com/auth/callback")){
                SharedPreferences sharedpreferences = getApplication().getSharedPreferences("UserCode",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                int p = request.getUrl().toString().indexOf("&",45);
                editor.putString("Code",request.getUrl().toString().substring(45,p));
                editor.commit();
                login.this.finish();
                return true;
            }
            return false;
        }
    }
}