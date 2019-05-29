package com.uu.skip;

import android.content.Context;

import java.util.ArrayList;

/**
 * 配置类
 * author：zhangguiyou
 * date: 2019-05-28.
 */
public class Config {


    /**
     * 已选择自动执行操作的APP
     */
    private ArrayList<AppBean> apps;

    /**
     * 延时时间，单位：ms
     */
    private int delay = 0;

    private static Config current;

    private Context mContext;

    private Config(Context context) {
        mContext = context;
    }

    public static synchronized Config getConfig(Context context) {
        if(current == null) {
            current = new Config(context.getApplicationContext());
        }
        return current;
    }

    public ArrayList<AppBean> getApps() {
        if (apps == null) {
            apps = new ArrayList<>();
        }
        return apps;
    }

    public void setApps(ArrayList<AppBean> apps) {
        this.apps = apps;
    }

    public void addApp(AppBean app) {
        if (apps == null) {
            apps = new ArrayList<>();
        }
        apps.add(app);
    }
}
