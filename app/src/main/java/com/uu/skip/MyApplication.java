package com.uu.skip;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;


/**
 * author：zhangguiyou
 * date: 2019-05-28.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "app_skip.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private DaoSession daoSession;
    public DaoSession getDaoSession() {
        return daoSession;
    }

}
