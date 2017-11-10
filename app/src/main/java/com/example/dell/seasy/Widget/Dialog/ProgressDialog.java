package com.example.dell.seasy.Widget.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Window;

import com.example.dell.seasy.R;

import butterknife.ButterKnife;

/**
 * Created by DELL on 2017/10/27.
 */

public class ProgressDialog extends Dialog {
    private Context context;
    public ProgressDialog(@NonNull Context context) {
        super(context, R.style.progress);
        this.context=context;
        init();
    }
    public void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_process);
        ButterKnife.bind(this);
        //设置selectPicPopWindow弹出窗体的背景
        getWindow().setBackgroundDrawableResource(R.color.white);
    }
    public void onBackPressed(){
        dismiss();
    }
}
