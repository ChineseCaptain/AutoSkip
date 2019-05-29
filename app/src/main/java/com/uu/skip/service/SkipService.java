package com.uu.skip.service;


import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.uu.skip.AppBean;
import com.uu.skip.utils.AccessibilityHelper;

import java.util.ArrayList;

/**
 * author：zhangguiyou
 * date: 2019-05-27.
 */
public class SkipService extends AccessibilityService {

    private static final String TAG = "SkipService";
    private ArrayList<AppBean> tasks;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

        if (tasks != null) {
            AccessibilityServiceInfo info = new AccessibilityServiceInfo();
            info.eventTypes = AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED;
            info.notificationTimeout = 100;
            String[] pkgs = new String[tasks.size()];
            for (int i = 0; i < tasks.size(); i++) {
                pkgs[i] = tasks.get(i).getAppPkg();
            }
            info.packageNames = pkgs;
            this.setServiceInfo(info);
        }
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if(event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            Log.i(TAG, "windows state changed");
            // 页面切换
            handleSpalshEvent(event);
        }
    }

    @Override
    public void onInterrupt() {

    }

    private void handleSpalshEvent(AccessibilityEvent event) {
        for (AppBean task : tasks) {
            if (event.getClassName().equals(task.getSkipClass())) {

                AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
                AccessibilityNodeInfo targetNode;

                // 通过id检索跳过按钮
                targetNode = AccessibilityHelper.findNodeInfosById(nodeInfo, task.getSkipId());
                if (targetNode == null) {
                    // 通过文本检索
                    targetNode = AccessibilityHelper.findNodeInfosById(nodeInfo, task.getSkipId());
                }

                if (targetNode != null) {
                    AccessibilityHelper.performClick(targetNode);
                }
            }
        }
    }
}
