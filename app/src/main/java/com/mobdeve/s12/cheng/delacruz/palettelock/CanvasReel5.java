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

public class CanvasReel5 extends View {

    private Rect mRectSlot5;

    private Paint mPaintSlot5;
    private Paint mPaintCircle1;
    private boolean lockStatus = false;

    private static int width;
    private static int height;

    private boolean matchingStatus = false;

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

        mPaintCircle1 = new Paint();
        mPaintCircle1.setAntiAlias(true);
        mPaintCircle1.setColor(Color.parseColor("#0c0c0c"));


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
            mPaintSlot5.setColor(Color.parseColor(hexColor));
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


        // Fifth Rectangle
        mRectSlot5.left = 0;
        mRectSlot5.top = topOffset;
        mRectSlot5.right = width;
        mRectSlot5.bottom = height;

//        canvas.drawRect(mRectSlot5, mPaintSlot5);

        RectF rectF = new RectF (0,topOffset,width,height);
        canvas.drawRoundRect(rectF,35,35,mPaintSlot5);

        float cx, cy;
        float radius = 40f;

        cx = getWidth() /2;
        cy = topOffset - mRectSlot5.top/2;

        canvas.drawCircle(cx,cy,radius,mPaintCircle1);


    }




}
