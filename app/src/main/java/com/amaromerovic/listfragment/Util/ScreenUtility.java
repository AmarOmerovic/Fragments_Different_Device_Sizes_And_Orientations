package com.amaromerovic.listfragment.Util;

import android.app.Activity;
import android.content.Context;
import android.view.WindowMetrics;

public class ScreenUtility {
    private final Activity activity;
    private final float dpWidth;
    private final float dpHeight;
    public static final int MAX_PHONE_PORTRAIT_WIDTH = 600;
    public static final int MAX_PHONE_LANDSCAPE_HEIGHT = 480;

    public ScreenUtility(Activity activity) {
        this.activity = activity;

        WindowMetrics display = activity.getWindowManager().getCurrentWindowMetrics();

        dpWidth = display.getBounds().width();
        dpHeight = display.getBounds().height();
    }


    public float getWidth(final Context context) {
        return dpWidth / context.getResources().getDisplayMetrics().density;
    }

    public float getHeight(final Context context) {
        return dpHeight / context.getResources().getDisplayMetrics().density;
    }
}
