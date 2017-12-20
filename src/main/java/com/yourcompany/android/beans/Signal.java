package com.yourcompany.android.beans;

/**
 * 新建与数据库表对应的实体类
 * Created by yuyang on 2017/8/2.
 */
public class Signal {
    //实体类的属性和表的字段名称一一对应
    private long collectionTime;
    private String AP_Name;
    private String AP_MAC;
    private int AP_RSS;

    public Signal() {
    }

    public long getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(long collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getAP_Name() {
        return AP_Name;
    }

    public void setAP_Name(String AP_Name) {
        this.AP_Name = AP_Name;
    }

    public String getAP_MAC() {
        return AP_MAC;
    }

    public void setAP_MAC(String AP_MAC) {
        this.AP_MAC = AP_MAC;
    }

    public int getAP_RSS() {
        return AP_RSS;
    }

    public void setAP_RSS(int AP_RSS) {
        this.AP_RSS = AP_RSS;
    }


}
