package com.zaozao.vultrManager.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by chenqisheng on 14/11/9.
 */
public class AppUtil {
    public static final String LOGTAG = "vultr-manager";

    public static void showToast(final Activity activity, final String content) {
        if (content != null) {
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Toast toast = Toast.makeText(activity, content,
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        }
    }
}
