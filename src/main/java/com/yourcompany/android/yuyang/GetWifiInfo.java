package com.yourcompany.android.yuyang;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.util.List;

/**
 * Created by yuyang on 2017/8/2.
 */
public class GetWifiInfo {
    //Wifi管理器
    private WifiManager mWifiManager;
    //获得的WiFi信息
    private WifiInfo mWifiInfo;
    //存放周围WiFi热点对象的列表
    private List<ScanResult> mWifiList;

    /**
     * 获得系统WiFi服务
     *
     * @param context
     */
    public GetWifiInfo(Context context) {
        //获得系统wifi服务
        mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        mWifiInfo = mWifiManager.getConnectionInfo();
    }

    /**
     * 获取扫描出的网络连接列表
     *
     * @return
     */
    public List<ScanResult> getWifiList() {
        mWifiList = mWifiManager.getScanResults();
        return mWifiList;
    }

}


