package com.example.dell.seasy.Base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


public  abstract class BaseFragment extends Fragment {
  private boolean isFirstVisible=true;
  private boolean isFirstInVisible=true;
  private boolean isPrepared;
  private Activity mActivity;
  protected String TAG;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getContentViewId()!=0){
            return inflater.inflate(getContentViewId(),null);
        }else
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initViewAndEvents(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
      mActivity=(Activity)context;
      TAG=this.getClass().getSimpleName();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }
    private synchronized void initPrepare(){
      if (isPrepared){
     onFirstUserVisible();
      }else {
       isPrepared=true;
      }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            if (isFirstVisible){
                isFirstVisible=false;
                initPrepare();
            }else {
                onUserVisible();
            }
        }else {
            if (isFirstInVisible){
                isFirstInVisible=false;
               onFirstUserInVisible();
            }else {
                onUserInvisible();
            }
        }
    }

    @Override
    public void onDestroy() {
        DestoryViewAndThing();
        super.onDestroy();
    }
    protected abstract void DestoryViewAndThing();

    protected abstract int getContentViewId();
    protected abstract void initViewAndEvents(View view);
    protected abstract void onFirstUserVisible();
    protected abstract void  onUserVisible();
    private void  onFirstUserInVisible(){};
    protected abstract void onUserInvisible();
    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(mActivity, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) {
            mActivity.finish();
        }
    }
}
