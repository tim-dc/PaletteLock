package com.mobdeve.s12.cheng.delacruz.palettelock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private CanvasReel1 mCanvasReel1;
    private CanvasReel2 mCanvasReel2;
    private CanvasReel3 mCanvasReel3;
    private CanvasReel4 mCanvasReel4;
    private CanvasReel5 mCanvasReel5;

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


    ImageView reelLock1;
    ImageView reelLock2;
    ImageView reelLock3;
    ImageView reelLock4;
    ImageView reelLock5;


    TextView counter;

//    private TextView counterText = (TextView)findViewById(R.id.counter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        Metronome metronome = new Metronome();
        timer.schedule(metronome,
                2000,
                2000);

        counter = findViewById(R.id.counter);
        mCanvasReel1 = findViewById(R.id.reel1);
        mCanvasReel2 = findViewById(R.id.reel2);
        mCanvasReel3 = findViewById(R.id.reel3);
        mCanvasReel4 = findViewById(R.id.reel4);
        mCanvasReel5 = findViewById(R.id.reel5);

        reelLock1 = (ImageView)findViewById(R.id.lock1);
        reelLock2 = (ImageView)findViewById(R.id.lock2);
        reelLock3 = (ImageView)findViewById(R.id.lock3);
        reelLock4 = (ImageView)findViewById(R.id.lock4);
        reelLock5 = (ImageView)findViewById(R.id.lock5);

        findViewById(R.id.reel1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel1.lockColor(1);
                reelLock1.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.reel2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel2.lockColor(2);
                reelLock2.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.reel3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel3.lockColor(3);
                reelLock3.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.reel4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel4.lockColor(4);
                reelLock4.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.reel5).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel5.lockColor(5);
                reelLock5.setVisibility(View.VISIBLE);
            }
        });

    }

    private void unlockReels(boolean reel1, boolean reel2, boolean reel3, boolean reel4, boolean reel5) {

        if(reel1){
            reelLock1.setVisibility(View.INVISIBLE);
        }
        if(reel2){
            reelLock2.setVisibility(View.INVISIBLE);
        }
        if(reel3){
            reelLock3.setVisibility(View.INVISIBLE);
        }
        if(reel4){
            reelLock4.setVisibility(View.INVISIBLE);
        }
        if(reel5){
            reelLock5.setVisibility(View.INVISIBLE);
        }


    }

    private class Metronome extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

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
                    r5+=randomNum;

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
                        mCanvasReel1.resetLock();
                        mCanvasReel2.resetLock();
                        mCanvasReel3.resetLock();
                        mCanvasReel4.resetLock();
                        mCanvasReel5.resetLock();
                        unlockReels(true,true,true,true,true);

                    }else currentCount++;

                    // CurrentCount = 1

                    // Swap Colors
//                mCanvasReel.swapColor();


                    mCanvasReel1.swapColor(1,r1,g1,b1, mCanvasReel1.isLocked());
                    mCanvasReel2.swapColor(2,r2,g2,b2, mCanvasReel2.isLocked());
                    mCanvasReel3.swapColor(3,r3,g3,b3, mCanvasReel3.isLocked());
                    mCanvasReel4.swapColor(4,r4,g4,b4, mCanvasReel4.isLocked());
                    mCanvasReel5.swapColor(5,r5,g5,b5, mCanvasReel5.isLocked());

                    counter.setText(String.valueOf(currentCount));
                }
            });

        }
    }
}