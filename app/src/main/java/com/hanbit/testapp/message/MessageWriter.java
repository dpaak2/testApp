package com.hanbit.testapp.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MessageWriter extends AppCompatActivity {
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = MessageWriter.this;
        Intent intent = getIntent(); /*받은 인텐트 담아줌 */
        LinearLayout frame = new LinearLayout(context);
        LinearLayout.LayoutParams mm = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams mw = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        frame.setLayoutParams(mm);
/*------------spec 나누기 -----------------*/
        String spec = intent.getExtras().getString("spec").toString();
        String id = spec.split(",")[0]; /*, 기준으로 나눠주고  id*/
        String phone = spec.split(": ")[1].split(",")[0];/*나누고 phone*/
        String name = spec.split(": ")[2];
/*---------------------------------------HYBRID--------------------------------------*/
        WebView wv = new WebView(context);
        WebSettings settings = wv.getSettings();
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
       // final String temp="";
        wv.addJavascriptInterface(new JavascriptInterface() { /*이지점에 도달하지 않으면 존재하지 않음*/
            @Override
            @android.webkit.JavascriptInterface /*annotation*/
            public void showToast(String message) {
                Toast.makeText(context,temp+message,Toast.LENGTH_LONG).show();
            }
            @Override @android.webkit.JavascriptInterface
            public void sendMessage(String message){
                temp=message;
            }
        }, "HYBRID");
        wv.loadUrl("file:///android_asset/www/html/messageWrite.html");
        frame.addView(wv);
        setContentView(frame);

    }

    /*------------------------------proxy pattern ------------------------------------ */
    public interface JavascriptInterface { /*JSON 을 던짐 */
        public void showToast(String message);

        @android.webkit.JavascriptInterface
        void sendMessage(String message);
    }
}
