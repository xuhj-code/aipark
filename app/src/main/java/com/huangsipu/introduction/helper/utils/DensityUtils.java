//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.huangsipu.introduction.helper.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;

public class DensityUtils {
    private static final String TAG = DensityUtils.class.getSimpleName();

    public DensityUtils() {
    }

    public static int dip2px(Context context, int dip) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((float) dip * scale + 0.5F * (float) (dip >= 0 ? 1 : -1));
    }

    public static int px2dip(Context context, int px) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((float) px / scale + 0.5F * (float) (px >= 0 ? 1 : -1));
    }

    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5F);
    }

    public static int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5F);
    }

    public static Point getScreenMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        Log.i("DisplayUtil", "Screen---Width = " + w_screen + " Height = " + h_screen + " densityDpi = " + dm.densityDpi);
        return new Point(w_screen, h_screen);
    }

    public static int getScreenMetricsDpi(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int dpi = dm.densityDpi;
        Log.i("DisplayUtil", "dpi----" + dpi);
        return dpi;
    }

    public static String getResolution(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        return w_screen + "x" + h_screen;
    }

    public static float getScreenRate(Context context) {
        Point P = getScreenMetrics(context);
        float H = (float) P.y;
        float W = (float) P.x;
        return H / W;
    }
}
