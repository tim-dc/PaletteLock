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

public class CanvasReel1 extends View {

    private Rect mRectSlot1;
    private Paint mPaintSlot1;

    private boolean lockStatus1 = false;

    private Paint mPaintCircle1;
    private static int width;
    private static int height;

    public CanvasReel1(Context context) {
        super(context);

        init(null);
    }

    public CanvasReel1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CanvasReel1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CanvasReel1(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mRectSlot1 = new Rect();

        mPaintSlot1 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintSlot1.setColor(Color.rgb(123,150,72));

        mPaintCircle1 = new Paint();
        mPaintCircle1.setAntiAlias(true);
        mPaintCircle1.setColor(Color.parseColor("#264653"));

    }


    public void swapColor(int reelNum, int red, int green, int blue, boolean status) {

        if(status){

        }else{
            mPaintSlot1.setColor(Color.rgb(red,green,blue));
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

        lockStatus1 = true;
    }

    public boolean isLocked()
    {
        return lockStatus1;
    }

    public void resetLock(){
        lockStatus1 = false;
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


        // First Rectangle
        mRectSlot1.left = 0;
        mRectSlot1.top = topOffset;
        mRectSlot1.right = width;
        mRectSlot1.bottom = height;

        canvas.drawRect(mRectSlot1, mPaintSlot1);


        float cx, cy;
        float radius = 40f;

        cx = getWidth() /2;
        cy = topOffset - mRectSlot1.top/2;

        canvas.drawCircle(cx,cy,radius,mPaintCircle1);



    }




}
