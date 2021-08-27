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
    private Paint mPaintCircle5;
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

        mPaintCircle5 = new Paint();
        mPaintCircle5.setAntiAlias(true);
        mPaintCircle5.setColor(Color.parseColor("#e76f51"));


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

        int topOffset = 100;
        int leftOffset = 50;
        int botOffset = 200;
        int subtractWidth =  leftOffset*2;
        int subtractHeight = topOffset*2;


        // Fifth Rectangle
        mRectSlot5.left = 0;
        mRectSlot5.top = topOffset;
        mRectSlot5.right = width;
        mRectSlot5.bottom = height;

        canvas.drawRect(mRectSlot5, mPaintSlot5);

        float cx, cy;
        float radius = 40f;

        cx = getWidth() /2;
        cy = topOffset - mRectSlot5.top/2;

        canvas.drawCircle(cx,cy,radius,mPaintCircle5);


    }




}
