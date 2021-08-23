package com.mobdeve.s12.cheng.delacruz.palettelock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private CanvasReel1 mCanvasReel;

    private int r1 = 22;
    private int r2 = 53;
    private int g1 = 44;
    private int g2 = 2;
    private int b1 = 53;
    private int b2 = 10;

    private int currentCount=0;

//    private TextView counterText = (TextView)findViewById(R.id.counter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


        mCanvasReel = (CanvasReel1) findViewById(R.id.reel1);

        findViewById(R.id.btn_lock_reel1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel.lockColor(1);
            }
        });

        findViewById(R.id.btn_lock_reel2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel.lockColor(2);

            }
        });


        findViewById(R.id.btn_swap_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mCanvasReel.swapColor(1,50,50,163);
                Random rand = new Random();

                int upperbound = 50;
                int randomNum = rand.nextInt(upperbound);
                r1+=randomNum;
                randomNum = rand.nextInt(upperbound);
                r2+=randomNum;

                randomNum = rand.nextInt(upperbound);
                g1+=randomNum;
                randomNum = rand.nextInt(upperbound);
                g2+=randomNum;

                randomNum = rand.nextInt(upperbound);
                b1+=randomNum;
                randomNum = rand.nextInt(upperbound);
                b2+=randomNum;

                mCanvasReel.swapColor(1,r1,g1,b1, mCanvasReel.isLocked(1));
                mCanvasReel.swapColor(2,r2,g2,b2, mCanvasReel.isLocked(2));

//                counterText.setText(currentCount);

                if(currentCount == 4)
                {
                    currentCount = 1;
                    mCanvasReel.resetLock();

                }else currentCount++;

            }
        });





    }
}