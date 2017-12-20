package com.yourcompany.android.activitys;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.yourcompany.android.R;
import com.yourcompany.android.utils.MySortBySSID;
import com.yourcompany.android.utils.WifiUtil;
import com.yourcompany.android.yuyang.MyDatabaseHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by yuyang on 2017/8/2.
 */
public class AndroidMainActivity extends Activity {
    private static TextView textView1;
    private static TextView textView2;
    private static TextView textView3;
    private Button start;
    private Button stop;
    private Button about;
    private MyDatabaseHelper dbHelper;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        about = (Button) findViewById(R.id.about);
        textView1.setMovementMethod(ScrollingMovementMethod.getInstance());
//        textView3.setText("Copyright © 2017 Yu Yang. All rights reserved");
        start.setOnClickListener(new collectListener());
        stop.setOnClickListener(new stopListener());
        about.setOnClickListener(new aboutListener());

    }


    class collectListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            handler.post(runnable);
        }
    }

    class stopListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            handler.removeCallbacks(runnable);
            Toast.makeText(AndroidMainActivity.this, "信号已经停止采集", Toast.LENGTH_SHORT).show();
        }
    }

    class aboutListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(AndroidMainActivity.this, AboutActivity.class);
            AndroidMainActivity.this.startActivity(intent);
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textView2.setText("定位的AP名称及信号强度");
            //实例化常量值
            ContentValues values = new ContentValues();
            //创建sqLite数据库，名称为WiFi
            dbHelper = new MyDatabaseHelper(AndroidMainActivity.this, "WiFi", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String info = "";
            //获取扫描出的网络连接列表
            List<ScanResult> results = WifiUtil.getAllNetWorkList(AndroidMainActivity.this);
            //去除同名SSID
            List<ScanResult> noSameNameResults = WifiUtil.noSameName(results);
            //对集合中的对象按照SSID名称进行排序
            Collections.sort(noSameNameResults, new MySortBySSID());

            for (int i = 0; i < noSameNameResults.size(); i++) {
                info += noSameNameResults.get(i).SSID + ":" + noSameNameResults.get(i).level + "dBm" + "\n";
                Date date = new Date();
                DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                String collectionTime = f.format(date);
                values.put("CollectionTime", collectionTime);
                values.put("AP_Name", noSameNameResults.get(i).SSID);
                values.put("AP_MAC", noSameNameResults.get(i).BSSID);
                values.put("AP_RSS", noSameNameResults.get(i).level);
                db.insert("rssi", null, values);
            }
            textView1.setText(info);
            Toast.makeText(AndroidMainActivity.this, "信号正在采集中...", Toast.LENGTH_SHORT).show();
            System.out.println("信号正在采集中...");
            handler.postDelayed(runnable, 5000);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * 此方法用于初始化菜单，其中menu参数就是即将要显示的Menu实例。 返回true则显示该menu,false 则不显示;
         * (只会在第一次初始化菜单时调用) Inflate the menu; this adds items to the action bar
         * if it is present.
         */
        getMenuInflater().inflate(R.layout.main, menu);
        return true;
    }
}
