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

public class CanvasReel4 extends View {

    private Rect mRectSlot4;

    private Paint mPaintSlot4;

    private boolean lockStatus4 = false;

    private static int width;
    private static int height;

    public CanvasReel4(Context context) {
        super(context);

        init(null);
    }

    public CanvasReel4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CanvasReel4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CanvasReel4(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mRectSlot4 = new Rect();

        mPaintSlot4 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintSlot4.setColor(Color.rgb(43,150,32));

    }


    public void swapColor(int reelNum, int red, int green, int blue, boolean status) {

        if(status){

        }else{
            mPaintSlot4.setColor(Color.rgb(red,green,blue));
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
        lockStatus4 = true;
    }

    public boolean isLocked()
    {
        return lockStatus4;
    }

    public void resetLock(){
        lockStatus4 = false;

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


        // Fourth Rectangle
        mRectSlot4.left = 0;
        mRectSlot4.top = 0;
        mRectSlot4.right = width;
        mRectSlot4.bottom = height;

        canvas.drawRect(mRectSlot4, mPaintSlot4);



    }




}
