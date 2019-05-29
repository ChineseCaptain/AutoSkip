package com.uu.skip;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 应用信息
 * author：zhangguiyou
 * date: 2019-05-27.
 */
@Entity
public class AppBean {

    /**
     * App的包名
     */
    private String appPkg;

    /**
     * APP的名字
     */
    private String appName;

    /**
     * 当前适配的APP版本号
     */
    private String appVersion;

    /**
     * 需要跳过的Activity名
     */
    private String skipClass;

    /**
     * 跳过按钮关键字
     */
    private String skipName;

    /**
     * 跳过按钮的id
     */
    private String skipId;

    private boolean checked = true;

    public AppBean(String pkgName) {
        this.appPkg = pkgName;
    }

    @Generated(hash = 1204744184)
    public AppBean(String appPkg, String appName, String appVersion,
            String skipClass, String skipName, String skipId, boolean checked) {
        this.appPkg = appPkg;
        this.appName = appName;
        this.appVersion = appVersion;
        this.skipClass = skipClass;
        this.skipName = skipName;
        this.skipId = skipId;
        this.checked = checked;
    }

    @Generated(hash = 285800313)
    public AppBean() {
    }

    public String getAppPkg() {
        return appPkg;
    }

    public void setAppPkg(String appPkg) {
        this.appPkg = appPkg;
    }

    public String getSkipClass() {
        return skipClass;
    }

    public void setSkipClass(String skipClass) {
        this.skipClass = skipClass;
    }

    public String getSkipName() {
        return skipName;
    }

    public void setSkipName(String skipName) {
        this.skipName = skipName;
    }

    public String getSkipId() {
        return skipId;
    }

    public void setSkipId(String skipId) {
        this.skipId = skipId;
    }

    public boolean getChecked() {
        return this.checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
