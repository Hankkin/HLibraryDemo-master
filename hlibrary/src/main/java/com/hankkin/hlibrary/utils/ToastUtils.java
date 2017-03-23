package com.hankkin.hlibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Hankkin on 16/7/8.
 */
public class ToastUtils {
    /**
     * 提示字符串
     * short Toast
     *
     * @param context
     * @param text
     */
    public static void showToast(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 提示字符串
     * short Toast
     *
     * @param context
     * @param text
     */
    public static void showLToast(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * 提示根据ResId关联字符串
     * short Toast
     *
     * @param context
     * @param resId
     */
    public static void showToast(Context context, int resId) {
        Toast toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 提示根据ResId关联字符串
     * 时常long	Toast
     *
     * @param context
     * @param resId
     */
    public static void showLToast(Context context, int resId) {
        Toast toast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
        toast.show();
    }
}
