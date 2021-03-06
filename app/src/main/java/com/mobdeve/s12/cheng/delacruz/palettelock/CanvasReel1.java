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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CanvasReel1 extends View {

    private Rect mRectSlot1;
    private Paint mPaintSlot1;

    private Rect mBorder;
    private Paint mBorderPaint;
    private boolean lockStatus = false;

    private Paint mPaintCircle1;
    private Paint mPaintCircle2;
    private static int width;
    private static int height;

    private boolean matchingStatus = false;

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
        mBorder = new Rect();

        mPaintSlot1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintSlot1.setColor(Color.rgb(123,150,72));
        mBorderPaint.setColor(Color.rgb(0,0,0));

        mPaintCircle1 = new Paint();
        mPaintCircle1.setAntiAlias(true);
        mPaintCircle1.setColor(Color.parseColor("#0c0c0c"));
//
//        mPaintCircle2 = new Paint();
//        mPaintCircle2.setAntiAlias(true);
//        mPaintCircle2.setColor(Color.parseColor("#faf8ef"));
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
              mPaintSlot1.setColor(Color.parseColor(hexColor));
        }

        postInvalidate();
    }

    public void swapReferenceColor(String hexColor){
        mPaintCircle1.setColor(Color.parseColor(hexColor));
    }

    public void lockColor(boolean status)
    {
        setLockStatus(status);
    }

    public boolean isMatchingStatus(){

        return matchingStatus;
    }

    public void setMatchingStatus(boolean matchStatus){
        matchingStatus = matchStatus;
    }

    public boolean getLockStatus( )
    {
        return lockStatus;
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

        int borderOffset = 120;

        // Border Rectangle
        mBorder.left = 0;
        mBorder.top = topOffset;
        mBorder.right = width ;
        mBorder.bottom = height ;

        // First Rectangle
        mRectSlot1.left = 0 - borderOffset;
        mRectSlot1.top = topOffset - borderOffset;
        mRectSlot1.right = width - borderOffset;
        mRectSlot1.bottom = height - borderOffset;




//        canvas.drawRect(mRectSlot1, mPaintSlot1);

//        RectF rectG = new RectF (0,topOffset,width+2,height+2);

        RectF rectF = new RectF (0,topOffset,width,height);
//        canvas.drawRoundRect(rectG,35, 35, mBorderPaint);
        canvas.drawRoundRect(rectF,35 ,35, mPaintSlot1);



        float cx, cy;
        float radius = 40f;

        cx = getWidth() / 2;
        cy = mRectSlot1.top +topOffset/2;

//        canvas.drawCircle(cx,cy,radius,mPaintCircle2);

        cx = getWidth() / 2;
        cy = topOffset - mBorder.top/2;

        canvas.drawCircle(cx,cy,radius,mPaintCircle1);



    }




}
