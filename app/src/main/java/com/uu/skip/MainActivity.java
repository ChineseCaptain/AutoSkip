package com.uu.skip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.uu.skip.utils.CmnConstrants;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_log)
    TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        IntentFilter filter = new IntentFilter(CmnConstrants.ACTION_MSG);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);

        AppBean app = new AppBean();
        app.setAppName("头条");
        app.setAppPkg("com.ss.android.article.news");
        app.setChecked(true);
        app.setSkipClass("com.ss.android.article.news.activity.SplashBadgeActivity");
        app.setSkipName("跳过广告");
        Config.getConfig(this).addApp(app);

        AppBean pipixia = new AppBean();
        pipixia.setAppName("皮皮虾");
        pipixia.setAppPkg("com.sup.android.superb");
        pipixia.setChecked(true);
        pipixia.setSkipClass("com.sup.android.base.MainActivity");
        pipixia.setSkipName("跳过广告");
        Config.getConfig(this).addApp(pipixia);
    }

    @OnClick({R.id.btn_guide, R.id.btn_apps, R.id.btn_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_guide:
                break;
            case R.id.btn_apps:
                break;
            case R.id.btn_switch:
                openAccessibilityServiceSettings();
                break;
        }
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(CmnConstrants.ACTION_MSG)) {
                String msg = intent.getStringExtra(CmnConstrants.KEY_MSG);
                addToLog(msg);
            }
        }
    };

    /**
     * 输出一条log到控制台
     *
     * @param msg
     */
    private void addToLog(String msg) {
        if (msg == null || TextUtils.isEmpty(msg)) {
            return;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        StringBuffer buffer = new StringBuffer();
        buffer.append(df.format(new Date())).append(": ").append(msg).append("\n");
        buffer.append(tvLog.getText().toString());
        tvLog.setText(buffer.toString());
    }


    /**
     * 打开辅助服务的设置
     */
    private void openAccessibilityServiceSettings() {
        try {
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, "", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
