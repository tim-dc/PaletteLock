package com.mobdeve.s12.cheng.delacruz.palettelock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CanvasReel3 extends View {

    private Rect mRectSlot3;

    private Paint mPaintSlot3;

    private Paint mPaintCircle3;
    private boolean lockStatus3 = false;

    private static int width;
    private static int height;

    public CanvasReel3(Context context) {
        super(context);

        init(null);
    }

    public CanvasReel3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CanvasReel3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CanvasReel3(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mRectSlot3 = new Rect();

        mPaintSlot3 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintSlot3.setColor(Color.rgb(3,88,150));

        mPaintCircle3 = new Paint();
        mPaintCircle3.setAntiAlias(true);
        mPaintCircle3.setColor(Color.parseColor("#e9c46a"));

    }


    public void swapColor(int reelNum, int red, int green, int blue, boolean status) {

        if(status){

        }else{
            mPaintSlot3.setColor(Color.rgb(red,green,blue));
        }

        postInvalidate();
    }

    public void lockColor(int reelNum)
    {
        if(isLocked())
        {

        }else {
            setLockStatus();
        }

    }

    public void setLockStatus(){

        lockStatus3 = true;
    }

    public boolean isLocked()
    {
        return lockStatus3;
    }

    public void resetLock(){

        lockStatus3 = false;

        // if already complete, don't unlock
    }

    @Override
    protected void onDraw(Canvas canvas)    {
//        canvas.drawColor(Color.RED);

        width = canvas.getWidth();
        height = canvas.getHeight();

        int topOffset = 100;
        int leftOffset = 50;
        int botOffset = 200;
        int subtractWidth =  leftOffset*2;
        int subtractHeight = topOffset*2;

        int one, two;

        // Third Rectangle
        mRectSlot3.left = 0;
        mRectSlot3.top = topOffset;
        mRectSlot3.right = width;
        mRectSlot3.bottom = height;

        canvas.drawRect(mRectSlot3, mPaintSlot3);


        float cx, cy;
        float radius = 40f;

        cx = getWidth() /2;
        cy = topOffset - mRectSlot3.top/2;

        canvas.drawCircle(cx,cy,radius,mPaintCircle3);



    }




}
