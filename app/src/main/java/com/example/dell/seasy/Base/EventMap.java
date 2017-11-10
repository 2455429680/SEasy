package com.example.dell.seasy.Base;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by DELL on 2017/10/27.
 */
public class EventMap {
    //事件总线基类
    public static class BaseEvent {
        public String code;
        public String message;
    }
    //错误类存储器
    public static HashMap<String,String> ERROR_MAP=new HashMap<>();
    static {
        ERROR_MAP.put("-1","上传失败");
        ERROR_MAP.put("0","连接超时，请检查网络设置");
        ERROR_MAP.put("1","服务器内部错误，请重试");
        ERROR_MAP.put("119","未获得相应权限");
        ERROR_MAP.put("206","操作失败");

    }
    public static String pickMessage(String code){
        if (TextUtils.isEmpty(code))
            return null;
        if (ERROR_MAP.containsKey(code))
            return ERROR_MAP.get(code);
        return null;
    }
    public static class HExceptionEvent extends BaseEvent{
      public static boolean isPickedMessage=false;
        public HExceptionEvent(String message){
            this.message=message;
            this.isPickedMessage=true;
        }
        public HExceptionEvent(int code,String message){
            this.code=String.valueOf(code);
            this.isPickedMessage=ERROR_MAP.containsKey(code);
            String pick=pickMessage(this.code);
            if (TextUtils.isEmpty(pick))
                this.message=message;
            else
                this.message=pick;
        }
    }
}
