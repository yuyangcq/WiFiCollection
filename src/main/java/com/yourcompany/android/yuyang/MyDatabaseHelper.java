package com.yourcompany.android.yuyang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yuyang on 2017/8/2.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_RSSI = "create table rssi (CollectionTime varchar(30),AP_Name varchar(30),AP_MAC varchar(30),AP_RSS INTEGER)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
//        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.print("创建成功！");
        //调用SQLiteDatabase中的execSQL（）执行建表语句。
        db.execSQL(CREATE_RSSI);
        //Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.print("东华大学");
    }
}
