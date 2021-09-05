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

public class CanvasReel2 extends View {

    private Rect mRectSlot2;

    private Paint mPaintSlot2;

    private boolean lockStatus = false;

    private Paint mPaintCircle1;
    private static int width;
    private static int height;

    private boolean matchingStatus = false;

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

        mPaintCircle1 = new Paint();
        mPaintCircle1.setAntiAlias(true);
        mPaintCircle1.setColor(Color.parseColor("#2a9d8f"));

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
            mPaintSlot2.setColor(Color.parseColor(hexColor));
        }

        postInvalidate();
    }

    public void lockColor()
    {
        if(isLocked())
        {

        }else {
            setLockStatus();
        }

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
    public void setLockStatus(){

        lockStatus = true;
    }

    public boolean isLocked()
    {
        return lockStatus;
    }

    public void resetLock(boolean allMatched){

        // if already complete, don't unlock

//        System.out.println("Reel1: LS: " + lockStatus + " MS: " + matchingStatus );
        if(matchingStatus){
            // If all colors are matching
            if(allMatched)
            {
                lockStatus = false;
                matchingStatus = false;
            }else {
                lockStatus = true;
                matchingStatus = true;
            }
        }else
            lockStatus = false;
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
        mRectSlot2.left = 0;
        mRectSlot2.top = topOffset;
        mRectSlot2.right = width;
        mRectSlot2.bottom = height;

//        canvas.drawRect(mRectSlot2, mPaintSlot2);

        RectF rectF = new RectF (0,topOffset,width,height);
        canvas.drawRoundRect(rectF,35,35,mPaintSlot2);

        float cx, cy;
        float radius = 40f;

        cx = getWidth() /2;
        cy = topOffset - mRectSlot2.top/2;

        canvas.drawCircle(cx,cy,radius,mPaintCircle1);



    }




}
