package com.mobdeve.s12.cheng.delacruz.palettelock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CanvasReel4 extends View {

    private Rect mRectSlot4;

    private Paint mPaintSlot4;
    private Paint mPaintCircle1;

    private boolean lockStatus = false;

    private static int width;
    private static int height;

    private boolean matchingStatus = false;

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

        mPaintCircle1 = new Paint();
        mPaintCircle1.setAntiAlias(true);
        mPaintCircle1.setColor(Color.parseColor("#f4a261"));

    }


    public void changeGoalColor (String hexColor)
    {
        mPaintCircle1.setAntiAlias(true);
        mPaintCircle1.setColor(Color.parseColor(hexColor));

        postInvalidate();
    }

    public void swapColor(String hexColor, boolean status) {

        if(status){
        }else{
//            mPaintSlot1.setColor(Color.rgb(red,green,blue));
            mPaintSlot4.setColor(Color.parseColor(hexColor));
        }

        postInvalidate();
    }

    public void lockColor(boolean status)
    {
        setLockStatus(status);
    }


    public boolean getLockStatus()
    {
        return lockStatus;
    }

    public boolean isMatchingStatus(){
        return matchingStatus;
    }

    public void setMatchingStatus(boolean matchStatus){
        matchingStatus = matchStatus;
    }

    public void setLockStatus(boolean status){
        lockStatus = status;
    }

    public boolean isLocked()
    {
        return lockStatus;
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


        // Fourth Rectangle
        mRectSlot4.left = 0;
        mRectSlot4.top = topOffset;
        mRectSlot4.right = width;
        mRectSlot4.bottom = height;

//        canvas.drawRect(mRectSlot4, mPaintSlot4);

        RectF rectF = new RectF (0,topOffset,width,height);
        canvas.drawRoundRect(rectF,35,35,mPaintSlot4);


        float cx, cy;
        float radius = 40f;

        cx = getWidth() /2;
        cy = topOffset - mRectSlot4.top/2;

        canvas.drawCircle(cx,cy,radius,mPaintCircle1);

    }




}
