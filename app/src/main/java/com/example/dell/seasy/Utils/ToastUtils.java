package com.example.dell.seasy.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DELL on 2017/10/27.
 */

public class ToastUtils {
    public static void showToast(Context context,String text){
        Toast toast= Toast.makeText(context,text,Toast.LENGTH_SHORT);
        toast.show();
    }
    public static void showLToast(Context context,String text){
        Toast toast=Toast.makeText(context,text,Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * 提示根据resId关联字符串
     * @param context
     * @param resId
     */
    public static  void showToast(Context context,int resId){
        Toast toast=Toast.makeText(context,resId,Toast.LENGTH_SHORT);
        toast.show();
    }
    public static void showLToast(Context context,int resId){
        Toast toast=Toast.makeText(context,resId,Toast.LENGTH_SHORT);
        toast.show();
    }
}
