package com.yourcompany.android.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.yourcompany.android.R;


/**
 * Created by yuyang on 2017/8/4.
 */
public class AboutActivity extends Activity {
    private static TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        textView2 = (TextView) findViewById(R.id.textView2);
    }


}
