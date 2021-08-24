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
    private int r3 = 100;
    private int r4 = 53;
    private int r5 = 70;

    private int g1 = 44;
    private int g2 = 2;
    private int g3 = 5;
    private int g4 = 77;
    private int g5 = 44;

    private int b1 = 53;
    private int b2 = 100;
    private int b3 = 83;
    private int b4 = 30;
    private int b5 = 40;

    private int currentCount=0;

    TextView counter;

//    private TextView counterText = (TextView)findViewById(R.id.counter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        counter = (TextView)findViewById(R.id.counter);
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

        findViewById(R.id.btn_lock_reel3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel.lockColor(3);
            }
        });

        findViewById(R.id.btn_lock_reel4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel.lockColor(4);
            }
        });

        findViewById(R.id.btn_lock_reel5).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel.lockColor(5);
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
                r3+=randomNum;
                randomNum = rand.nextInt(upperbound);
                r4+=randomNum;
                randomNum = rand.nextInt(upperbound);
                r4+=randomNum;

                randomNum = rand.nextInt(upperbound);
                g1+=randomNum;
                randomNum = rand.nextInt(upperbound);
                g2+=randomNum;
                randomNum = rand.nextInt(upperbound);
                g3+=randomNum;
                randomNum = rand.nextInt(upperbound);
                g4+=randomNum;
                randomNum = rand.nextInt(upperbound);
                g5+=randomNum;

                randomNum = rand.nextInt(upperbound);
                b1+=randomNum;
                randomNum = rand.nextInt(upperbound);
                b2+=randomNum;
                randomNum = rand.nextInt(upperbound);
                b3+=randomNum;
                randomNum = rand.nextInt(upperbound);
                b4+=randomNum;
                randomNum = rand.nextInt(upperbound);
                b5+=randomNum;

//                counterText.setText(currentCount);

                // Current count = 4

                if(currentCount == 4)
                {
                    currentCount = 1;
                    mCanvasReel.resetLock();

                }else currentCount++;

                // CurrentCount = 1

                // Swap Colors
//                mCanvasReel.swapColor();



                mCanvasReel.swapColor(1,r1,g1,b1, mCanvasReel.isLocked(1));
                mCanvasReel.swapColor(2,r2,g2,b2, mCanvasReel.isLocked(2));
                mCanvasReel.swapColor(3,r3,g3,b3, mCanvasReel.isLocked(3));
                mCanvasReel.swapColor(4,r4,g4,b4, mCanvasReel.isLocked(4));
                mCanvasReel.swapColor(5,r5,g5,b5, mCanvasReel.isLocked(5));

                counter.setText(String.valueOf(currentCount));



            }
        });

    }
}