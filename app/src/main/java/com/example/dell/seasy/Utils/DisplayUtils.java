package com.example.dell.seasy.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by DELL on 2017/10/27.
 */

public class DisplayUtils {
    public static int dp2px(int dp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());

    }

    /**
     * dp转换为px
     * @param context
     * @param dpValue
     * @return
     */
    public static int toPx(Context context,float dpValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        int pxValue=(int)(dpValue*scale+0.5f);
        return pxValue;
    }

    /**
     *
     * @param context
     * @return
     */
    public static DisplayMetrics displayMetrics(Context context){
        DisplayMetrics dm=new DisplayMetrics();
        WindowManager windowManager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        return  dm;
    }

    /**
     * dp转化为px
     * @param dp
     * @param resources
     * @return
     */
    public static int dpToPx(float dp, Resources resources){
        float px=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,resources.getDisplayMetrics());
        return (int)px;
    }

    /**
     * 将sp转换为px，保证文字大小不变
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context,float spValue){
        final  float fontScale=context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(spValue*fontScale+0.5f);
    }

    /**
     * 获取屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context){
        WindowManager windowManager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics=new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        return  outMetrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context){
        WindowManager windowManager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics=new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        return  outMetrics.heightPixels;
    }
    public static final int getHeightInPx(Context context){
        final int height=context.getResources().getDisplayMetrics().heightPixels;
        return  height;
    }
    public static final int getWidthInPx(Context context){
        final  int width=context.getResources().getDisplayMetrics().widthPixels;
        return width;
    }
    public static int dip2px(Context context,float dpValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
    public static int px2dip(Context context,float pxValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }

    /**
     * 隐藏软键盘
     * @param activity
     */
    public static void hideSoftInputMethod(Activity activity){
        View view=activity.getWindow().peekDecorView();
        if (view!=null){
            //隐藏虚拟键盘
            InputMethodManager inputMethodManager=(InputMethodManager)activity.getSystemService(activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
    public static void switchSoftInputMethod(Activity activity){
        //如果输入法已经显示则隐藏，反之则显示
        InputMethodManager imm=(InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
