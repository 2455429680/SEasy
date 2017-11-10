package com.example.dell.seasy.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.dell.seasy.Base.BaseFragment;
import com.example.dell.seasy.R;

public class DynamicFragment extends BaseFragment {

    public static final String FR_DYNAMIC_TAG="dynamic";

    public static DynamicFragment newInstance(String tag) {
        // Required empty public constructor
        DynamicFragment fragment=new DynamicFragment();
        Bundle args=new Bundle();
        args.putString(FR_DYNAMIC_TAG,tag);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_dynamic;
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
