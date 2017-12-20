package com.yourcompany.android.utils;

import android.net.wifi.ScanResult;

import java.util.Comparator;

/**
 * Created by yuyang on 2017/8/6.
 */
public class MySortBySSID implements Comparator<ScanResult> {
    /**
     * 比较字符串对象的大小
     * @param o1
     * @param o2
     * @return
     */
    public int compare(ScanResult o1, ScanResult o2) {

        String s1 = o1.SSID;
        String s2 = o2.SSID;
        if (s1.compareToIgnoreCase(s2) > 0) {
            return 1;
        }
        return -1;

    }
}
