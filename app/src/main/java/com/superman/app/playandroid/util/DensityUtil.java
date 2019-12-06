package com.superman.app.playandroid.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.superman.app.playandroid.AppContext;

/**
 * Created by superman on 2017/4/19.
 */

public class DensityUtil {
    public static DensityUtil Instance;

    private DensityUtil() {
    }

    public static DensityUtil getInstance() {
        if ( Instance == null ) {
            Instance = new DensityUtil();
        }
        return Instance;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = AppContext.Companion.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = AppContext.Companion.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px( float spValue) {
        final float fontScale = AppContext.Companion.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static void changeViewSize(Activity context, View view, float spValue) {
        WindowManager wm = context.getWindowManager();//获取屏幕宽高
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        ViewGroup.LayoutParams para = view.getLayoutParams();//获取drawerlayout的布局
        para.width = (int) (width * 0.7);//修改宽度
        para.height = height;//修改高度
        view.setLayoutParams(para); //设置修改后的布局。
    }


    /**
     * check if sdcard exist
     *
     * @return
     */
    public static boolean isSdcardExist() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }


    public static int getScreenWidth(){
        WindowManager wm = (WindowManager) AppContext.Companion.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        return width;
    }

}
