package com.ustc.leo.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.ustc.leo.app.Leo;

/**
 * Created by dell on 2017/12/24.
 * 测量方法
 */

public class DimenUtil {
    public static int getScreenWidth(){
        final Resources resources = Leo.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Leo.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
