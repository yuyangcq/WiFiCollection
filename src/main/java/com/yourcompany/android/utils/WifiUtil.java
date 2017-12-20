package com.yourcompany.android.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import com.yourcompany.android.yuyang.GetWifiInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyang on 2017/8/2.
 */
public class WifiUtil {
    /**
     * 获取扫描出的网络连接列表
     *
     * @param context
     * @return
     */
    public static List<ScanResult> getAllNetWorkList(Context context) {
        GetWifiInfo mWifiInfo = new GetWifiInfo(context);
        List<ScanResult> results = mWifiInfo.getWifiList();
        return results;
    }

    /**
     * 去除同名SSID
     *
     * @param list 需要去除同名的列表
     * @return 返回不包含同命的列表
     */
    public static List<ScanResult> noSameName(List<ScanResult> list) {
        List<ScanResult> newlist = new ArrayList<ScanResult>();
        for (ScanResult result : list) {
            if (!TextUtils.isEmpty(result.SSID) && !containName(newlist, result.SSID))
                newlist.add(result);
        }
        return newlist;
    }

    /**
     * 判断一个扫描结果中，是否包含了某个名称的WiFi
     *
     * @param sr
     * @param name
     * @return 返回true表示包含了该名称的WiFi，返回false表示不包含
     */

    public static boolean containName(List<ScanResult> sr, String name) {
        for (ScanResult result : sr) {
            if (!TextUtils.isEmpty(result.SSID) && result.SSID.equals(name))
                return true;
        }
        return false;
    }
}