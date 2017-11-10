package com.example.dell.seasy.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.example.dell.seasy.Utils.ToastUtils;
import com.example.dell.seasy.Widget.Dialog.ProgressDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BaseEventActivity extends AppCompatActivity {
    protected Activity activity;
    private ProgressDialog progressDialog;
    private boolean hasBus=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=this;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {

        if (hasBus)
            EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    /**
     * 事件观察者
     * @param baseEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventMap.BaseEvent baseEvent){
        if (baseEvent!=null&&baseEvent instanceof EventMap.HExceptionEvent){
            if (!TextUtils.isEmpty(baseEvent.message)){
                ToastUtils.showToast(activity,baseEvent.message);
            }
        }
    }
    /**
     * 显示loading
     */
    public void showLoadingDialog(){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(activity);
        }
        progressDialog.show();
    }
    /**
     * 隐藏loading
     */
    public void hideLoadingDialog(){
        if (progressDialog!=null){
            progressDialog.dismiss();
        }
    }
    public boolean isHasBus(){
        return hasBus;
    }
    public void  setHasBus(boolean hasBus){
        this.hasBus=hasBus;
        if (hasBus){
            EventBus.getDefault().register(this);
        }
    }

}
