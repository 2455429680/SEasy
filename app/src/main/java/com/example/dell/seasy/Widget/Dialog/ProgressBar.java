package com.example.dell.seasy.Widget.Dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.example.dell.seasy.Utils.DisplayUtils;

/**
 * Created by DELL on 2017/10/27.
 */

public class ProgressBar extends CustomView {
    final static  String ANDROIDXML="http://schemas.android.com/apk/res/android";
    int backgroundColor= Color.parseColor("#1E88E5");
    public ProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributeSet(attrs);

    }
    public void setAttributeSet(AttributeSet attributeSet){
        setMinimumHeight(DisplayUtils.dpToPx(32,getResources()));
        setMinimumWidth(DisplayUtils.dpToPx(32,getResources()));
        int backgroundColor=attributeSet.getAttributeResourceValue(ANDROIDXML,"background",-1);
        if (backgroundColor!=-1){
           setBackgroundColor(getResources().getColor(backgroundColor));
        }
        else {
            int background=attributeSet.getAttributeResourceValue(ANDROIDXML,"background",-1);
            if (background!=-1)
                setBackgroundColor(background);
            else
                setBackgroundColor(Color.parseColor("#1E88E5"));
        }
        setMinimumHeight(DisplayUtils.dpToPx(3,getResources()));
    }
    protected int makePressColor(){
        int r=(this.backgroundColor>>16)&0xff;
        int g=(this.backgroundColor>>8)&0xff;
        int b=(this.backgroundColor>>0)&0xff;
        return Color.argb(128,r,g,b);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
drawAnimation(canvas);
invalidate();
    }
    int arcD=1;
    int arcO=0;
    float rotateAngle=0;
    int limite=0;
    private void drawAnimation(Canvas canvas) {
        if (arcO == limite)
            arcD += 6;
        if (arcD >= 290 || arcO > limite) {
            arcO += 6;
            arcD -= 6;
        }
        if (arcO > limite + 290) {
            limite = arcO;
            arcO = limite;
            arcD = 1;
        }
        rotateAngle += 4;
        canvas.rotate(rotateAngle, getWidth() / 2, getHeight() / 2);

        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(),
                canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas temp = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(backgroundColor);
        temp.drawArc(new RectF(0, 0, getWidth(), getHeight()), arcO, arcD,
                true, paint);
        Paint transparentPaint = new Paint();
        transparentPaint.setAntiAlias(true);
        transparentPaint.setColor(getResources().getColor(
                android.R.color.transparent));
        transparentPaint.setXfermode(new PorterDuffXfermode(
                PorterDuff.Mode.CLEAR));
        temp.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2)
                - DisplayUtils.dpToPx(4, getResources()), transparentPaint);

        canvas.drawBitmap(bitmap, 0, 0, new Paint());
    }

    public void setBackgroundColor(int color) {
        super.setBackgroundColor(getResources().getColor(
                android.R.color.transparent));
        if (isEnabled())
            beforeBackGround = backgroundColor;
        this.backgroundColor = color;
    }

}

