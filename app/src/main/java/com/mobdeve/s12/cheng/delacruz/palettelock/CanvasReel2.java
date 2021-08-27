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

public class CanvasReel2 extends View {

    private Rect mRectSlot2;

    private Paint mPaintSlot2;

    private boolean lockStatus2 = false;

    private static int width;
    private static int height;

    public CanvasReel2(Context context) {
        super(context);

        init(null);
    }

    public CanvasReel2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CanvasReel2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CanvasReel2(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mRectSlot2 = new Rect();

        mPaintSlot2 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintSlot2.setColor(Color.rgb(100,50,92));
    }


    public void swapColor(int reelNum, int red, int green, int blue, boolean status) {

        if(status){

        }else{
            mPaintSlot2.setColor(Color.rgb(red,green,blue));
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

        lockStatus2 = true;
    }

    public boolean isLocked()
    {
        return lockStatus2;
    }

    public void resetLock(){
        lockStatus2 = false;
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


        // First Rectangle
        mRectSlot2.left = 0;
        mRectSlot2.top = 0;
        mRectSlot2.right = width;
        mRectSlot2.bottom = height;

        canvas.drawRect(mRectSlot2, mPaintSlot2);



    }




}
