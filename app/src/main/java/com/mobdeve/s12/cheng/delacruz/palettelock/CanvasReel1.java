package com.mobdeve.s12.cheng.delacruz.palettelock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CanvasReel1 extends View {

    private Rect mRectSlot1;
    private Paint mPaintSlot1;

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


    }

    @Override
    protected void onDraw(Canvas canvas)    {
//        canvas.drawColor(Color.RED);

        mRectSlot1.left = 10;
        mRectSlot1.top = 10;
        mRectSlot1.right = mRectSlot1.left + 10;
        mRectSlot1.bottom = mRectSlot1.top + 10;

        mPaintSlot1.setColor(Color.GREEN);

        canvas.drawRect(mRectSlot1, mPaintSlot1);


    }


}
