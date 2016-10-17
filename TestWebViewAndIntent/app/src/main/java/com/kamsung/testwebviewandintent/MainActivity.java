package com.kamsung.testwebviewandintent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new AndroidBridge(), "Android");
        webView.getSettings().setSupportMultipleWindows(true);
        webView.loadUrl("http://mybeak.com/test");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return true;
            }
        });

    }

    private class AndroidBridge{
        @JavascriptInterface
        public void startNewActivity(){
            Log.d("ttttttt", "ttttttttttttt");
            Intent intent = new Intent(MainActivity.this, SeceondActivity.class);
            startActivity(intent);
        }
    }
}
