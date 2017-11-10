package com.example.dell.seasy.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.dell.seasy.Base.BaseFragment;
import com.example.dell.seasy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends BaseFragment {


    public static final String FR_CHAT_TAG="chat";

    public static ChatFragment newInstance(String tag) {
        // Required empty public constructor
       ChatFragment fragment=new ChatFragment();
        Bundle args=new Bundle();
        args.putString(FR_CHAT_TAG,tag);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    protected int getContentViewId() {
        return R.layout.fragment_chat;
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
