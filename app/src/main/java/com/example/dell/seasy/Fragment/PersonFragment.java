package com.example.dell.seasy.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.dell.seasy.Base.BaseFragment;
import com.example.dell.seasy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends BaseFragment {

    public static final String FR_PERSON_TAG="person";
    public static PersonFragment newInstance(String tag) {
        // Required empty public constructor
        PersonFragment fragment=new PersonFragment();
        Bundle args=new Bundle();
        args.putString(FR_PERSON_TAG,tag);
        fragment.setArguments(args);
        return fragment;
    }






    @Override
    protected int getContentViewId() {
        return R.layout.fragment_person;
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
