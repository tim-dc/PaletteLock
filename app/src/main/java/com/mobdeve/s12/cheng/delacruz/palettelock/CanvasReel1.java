package com.mobdeve.s12.cheng.delacruz.palettelock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.Nullable;

public class CanvasReel1 extends View {

    private Rect mRectSlot1;
    private Rect mRectSlot2;
    private Rect mRectSlot3;
    private Rect mRectSlot4;
    private Rect mRectSlot5;

    private Paint mPaintSlot1;
    private Paint mPaintSlot2;
    private Paint mPaintSlot3;
    private Paint mPaintSlot4;
    private Paint mPaintSlot5;

    private boolean lockStatus1 = false;
    private boolean lockStatus2 = false;
    private boolean lockStatus3 = false;
    private boolean lockStatus4 = false;
    private boolean lockStatus5 = false;

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
        mRectSlot2 = new Rect();
        mRectSlot3 = new Rect();
        mRectSlot4 = new Rect();
        mRectSlot5 = new Rect();

        mPaintSlot1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSlot2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSlot3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSlot4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSlot5 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintSlot1.setColor(Color.rgb(123,150,72));
        mPaintSlot2.setColor(Color.rgb(100,50,92));

    }

    public void swapColor(int reelNum, int red, int green, int blue, boolean status) {


        if(status){

        }else{
            switch(reelNum){
                case 1:
                    mPaintSlot1.setColor(Color.rgb(red,green,blue));
                    break;

                case 2:
                    mPaintSlot2.setColor(Color.rgb(red,green,blue));
                    break;

                case 3:
                    mPaintSlot3.setColor(Color.rgb(red,green,blue));
                    break;

                case 4:
                    mPaintSlot4.setColor(Color.rgb(red,green,blue));
                    break;

                case 5:
                    mPaintSlot5.setColor(Color.rgb(red,green,blue));
                    break;
            }
        }

        postInvalidate();
    }

    public void lockColor(int reelNum)
    {
        if(isLocked(reelNum))
        {
        }else {
            setLockStatus(reelNum);
        }

    }

    public void setLockStatus(int reelNum){
        switch(reelNum)
        {
            case 1: lockStatus1 = true;
            case 2: lockStatus2 = true;
            case 3: lockStatus3 = true;
            case 4: lockStatus4 = true;
            case 5: lockStatus5 = true;
        }
    }


    public boolean isLocked(int reelNum)
    {
        switch(reelNum)
        {
            case 1: return lockStatus1;
            case 2: return lockStatus2;
            case 3: return lockStatus3;
            case 4: return lockStatus4;
            case 5: return lockStatus5;
        }

        return false;
    }

    public void resetLock(){
        lockStatus1 = false;
        lockStatus2 = false;
        lockStatus3 = false;
        lockStatus4 = false;
        lockStatus5 = false;

        // if already complete, don't unlock
    }

    @Override
    protected void onDraw(Canvas canvas)    {
//        canvas.drawColor(Color.RED);

        width = canvas.getWidth();
        height = canvas.getHeight();

        int topOffset = 50;
        int leftOffset = 50;
        int subtractWidth =  leftOffset*2;
        int subtractHeight = topOffset*2;

        // First Rectangle
        mRectSlot1.left = leftOffset;
        mRectSlot1.top = topOffset;
        mRectSlot1.right = mRectSlot1.left + 350;
        mRectSlot1.bottom = mRectSlot1.top + height-subtractHeight;

        canvas.drawRect(mRectSlot1, mPaintSlot1);

        // Second Rectangle
        mRectSlot2.left = mRectSlot1.right + leftOffset;
        mRectSlot2.top = topOffset;
        mRectSlot2.right = mRectSlot2.left + 350;
        mRectSlot2.bottom = mRectSlot2.top + height-subtractHeight;


        canvas.drawRect(mRectSlot2, mPaintSlot2);


    }




}
