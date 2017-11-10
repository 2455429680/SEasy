package com.example.dell.seasy.Base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.seasy.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends BaseEventActivity implements BaseViewInterface {
  protected LayoutInflater mInflater;
    protected String TAG;
    protected Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getSimpleName();
        activity=this;
        AppManager.getAppManager().addActivity(this);
        if (getContentId()!=0){
            setContentView(getContentId());
        }
        mInflater=getLayoutInflater();
        if (Build.VERSION.SDK_INT >= 21) {
            View view = getWindow().getDecorView();
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(getResources().getColor(R.color.transparent));
        }
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initBind();
        initView(savedInstanceState);
      if(getIntent()!=null){
          handleIntent(getIntent());
      }
    }

    /**
     * 打开一个activity 默认不关闭当前activity
     * @param cls
     */
    public void gotoActivity(Class<?> cls){
        gotoActivity(cls,false,null);
    }
    public void gotoActivity(Class<?> cls,boolean isCurrentActivity){
        gotoActivity(cls,isCurrentActivity,null);
    }
public void gotoActivity(Class<?> cls,boolean isCurrentActivity,Bundle ex){
    Intent intent=new Intent(this,cls);
    if (ex!=null)
        intent.putExtras(ex);
    startActivity(intent);
    if (isCurrentActivity){
        finish();
    }
}


    protected int getContentId(){
        return getLayoutId();
    }
 protected void back(){
     if (activity!=null){
         activity.finish();
     }
 }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
     protected void initBind(){
         ButterKnife.bind(activity);
    }
    protected void handleIntent(Intent intent){}
}
