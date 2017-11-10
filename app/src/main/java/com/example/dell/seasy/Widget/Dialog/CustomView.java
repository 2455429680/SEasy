package com.example.dell.seasy.Widget.Dialog;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by DELL on 2017/10/27.
 */

public class CustomView extends RelativeLayout {
    final int disabledBackgroundColor= Color.parseColor("#E2E2E2");
    int beforeBackGround;
    public CustomView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        if (enabled)
            setBackgroundColor(beforeBackGround);
        else
            setBackgroundColor(disabledBackgroundColor);
    }
}
