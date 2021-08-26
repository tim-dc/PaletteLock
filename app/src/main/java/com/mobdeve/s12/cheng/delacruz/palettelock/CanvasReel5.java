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

public class CanvasReel5 extends View {

    private Rect mRectSlot5;

    private Paint mPaintSlot5;

    private boolean lockStatus5 = false;

    private static int width;
    private static int height;

    public CanvasReel5(Context context) {
        super(context);

        init(null);
    }

    public CanvasReel5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CanvasReel5(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CanvasReel5(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mRectSlot5 = new Rect();

        mPaintSlot5 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintSlot5.setColor(Color.rgb(34,0,100));

    }


    public void swapColor(int reelNum, int red, int green, int blue, boolean status) {

        if(status){

        }else{
            mPaintSlot5.setColor(Color.rgb(red,green,blue));

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
        lockStatus5 = true;
    }

    public boolean isLocked()
    {
        return lockStatus5;
    }

    public void resetLock(){

        lockStatus5 = false;

        // if already complete, don't unlock
    }

    @Override
    protected void onDraw(Canvas canvas)    {
//        canvas.drawColor(Color.RED);

        width = canvas.getWidth();
        height = canvas.getHeight();

        int topOffset = 300;
        int leftOffset = 50;
        int botOffset = 200;
        int subtractWidth =  leftOffset*2;
        int subtractHeight = topOffset*2;


        // Fifth Rectangle
        mRectSlot5.left = leftOffset;
        mRectSlot5.top = topOffset;
        mRectSlot5.right = mRectSlot5.left + 350;
        mRectSlot5.bottom = mRectSlot5.top + height-subtractHeight + botOffset;

        canvas.drawRect(mRectSlot5, mPaintSlot5);


    }




}