package com.example.dell.seasy.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.dell.seasy.Base.BaseFragment;
import com.example.dell.seasy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPageFragment extends BaseFragment {
   public static final String FR_MAINPAGE_TAG="MainPage";

    public static MainPageFragment newInstance(String tag) {
        // Required empty public constructor
        MainPageFragment fragment=new MainPageFragment();
        Bundle args=new Bundle();
        args.putString(FR_MAINPAGE_TAG,tag);
        fragment.setArguments(args);
        return fragment;
    }





    @Override
    protected int getContentViewId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    protected void initViewAndEvents(View view) {

    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }
    @Override
    protected void DestoryViewAndThing() {

    }
}
