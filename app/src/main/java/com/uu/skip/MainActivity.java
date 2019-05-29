package com.uu.skip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLog = findViewById(R.id.tv_log);

        AppBean app = new AppBean();
        app.setAppName("头条");
        app.setAppPkg("com.ss.android.article.news");
        app.setChecked(true);
        app.setSkipClass(".activity.SplashBadgeActivity");
        app.setSkipName("跳过广告");
        Config.getConfig(this).addApp(app);
    }



    /**
     * 输出一条log到控制台
     * @param msg
     */
    private void addToLog(String msg) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        StringBuffer buffer = new StringBuffer();
        buffer.append(df.format(new Date())).append(": ").append(msg).append("\n");
        buffer.append(tvLog.getText().toString());
        tvLog.setText(buffer.toString());
    }
}
