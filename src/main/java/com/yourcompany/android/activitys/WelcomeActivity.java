package com.yourcompany.android.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.yourcompany.android.R;

/**
 * Created by yuyang on 2017/8/6.
 */
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Handler handler = new Handler();
        //当计时结束,跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, AndroidMainActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, 5000);
    }
}
