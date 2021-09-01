package com.mobdeve.s12.cheng.delacruz.palettelock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private CanvasReel1 mCanvasReel1;
    private CanvasReel2 mCanvasReel2;
    private CanvasReel3 mCanvasReel3;
    private CanvasReel4 mCanvasReel4;
    private CanvasReel5 mCanvasReel5;

    private ArrayList<String> pReel1 = new ArrayList<String>();
    private ArrayList<String> pReel2 = new ArrayList<String>();
    private ArrayList<String> pReel3 = new ArrayList<String>();
    private ArrayList<String> pReel4 = new ArrayList<String>();
    private ArrayList<String> pReel5 = new ArrayList<String>();

    // Hardcoded rgb values, Delete after arrays have their colors
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

        // Color Palletes (Color1,2,3,4,5) --->

        // 8ecae6,219ebc,023047,ffb703,fb8500
        pReel1.add("#8ecae6"); pReel2.add("#219ebc"); pReel3.add("#023047"); pReel4.add("#ffb703"); pReel5.add("#fb8500");
        // 264653,2a9d8f,e9c46a,f4a261,e76f51
        pReel1.add("#264653"); pReel2.add("#2a9d8f"); pReel3.add("#e9c46a"); pReel4.add("#f4a261"); pReel5.add("#e76f51");
        // ccd5ae,e9edc9,fefae0,faedcd,d4a373
        pReel1.add("#ccd5ae"); pReel2.add("#e9edc9"); pReel3.add("#fefae0"); pReel4.add("#faedcd"); pReel5.add("#d4a373");
        // cdb4db,ffc8dd,ffafcc,bde0fe,a2d2ff
        pReel1.add("#cdb4db"); pReel2.add("#ffc8dd"); pReel3.add("#ffafcc"); pReel4.add("#bde0fe"); pReel5.add("#a2d2ff");
        // f4f1de,e07a5f,3d405b,81b29a,f2cc8f
        pReel1.add("#f4f1de"); pReel2.add("#e07a5f"); pReel3.add("#3d405b"); pReel4.add("#81b29a"); pReel5.add("#f2cc8f");
        // 22223b,4a4e69,9a8c98,c9ada7,f2e9e4
        pReel1.add("#22223b"); pReel2.add("#4a4e69"); pReel3.add("#9a8c98"); pReel4.add("#c9ada7"); pReel5.add("#f2e9e4");
        // 6f1d1b,bb9457,432818,99582a,ffe6a7
        pReel1.add("#6f1d1b"); pReel2.add("#bb9457"); pReel3.add("#432818"); pReel4.add("#99582a"); pReel5.add("#ffe6a7");


        // Home Button
        findViewById(R.id.homeButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showConfirmExit();
            }
        });


        // Reels
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

    private void isMatching(int reelNum){



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

    private void showConfirmExit(){

        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.exit_popup);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_popup);

        Button btnClose = dialog.findViewById(R.id.btn_cancel);
        Button btnOk = dialog.findViewById(R.id.btn_ok);

        dialog.setCanceledOnTouchOutside(false);
        //dialog.setCancelable(false);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent;
                mIntent = new Intent(MainActivity.this, SelectLevel.class);
                startActivity(mIntent);
                finish();
            }
        });

        dialog.show();

    }

    private class Metronome extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Random rand = new Random();

                    int upperbound = 7;
                    int randomNum = rand.nextInt(upperbound);

                    // Reels 1 - 5

                    // random num generator the index
                    // get the hex values
                    pReel1.get(randomNum);
                    pReel2.get(randomNum);
                    pReel3.get(randomNum);
                    pReel4.get(randomNum);
                    pReel5.get(randomNum);
                    // convert to rgb

                    // input rgb in swapColor()

//                    // Red Values
//                    r1+=randomNum; randomNum = rand.nextInt(upperbound);
//                    r2+=randomNum; randomNum = rand.nextInt(upperbound);
//                    r3+=randomNum; randomNum = rand.nextInt(upperbound);
//                    r4+=randomNum; randomNum = rand.nextInt(upperbound);
//                    r5+=randomNum; randomNum = rand.nextInt(upperbound);
//
//                    // Green Values
//                    g1+=randomNum; randomNum = rand.nextInt(upperbound);
//                    g2+=randomNum; randomNum = rand.nextInt(upperbound);
//                    g3+=randomNum; randomNum = rand.nextInt(upperbound);
//                    g4+=randomNum; randomNum = rand.nextInt(upperbound);
//                    g5+=randomNum; randomNum = rand.nextInt(upperbound);
//
//                    // Blue Values
//                    b1+=randomNum; randomNum = rand.nextInt(upperbound);
//                    b2+=randomNum; randomNum = rand.nextInt(upperbound);
//                    b3+=randomNum; randomNum = rand.nextInt(upperbound);
//                    b4+=randomNum; randomNum = rand.nextInt(upperbound);
//                    b5+=randomNum;

                    // Unlocking all reels
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



                    // Swap Colors
                    mCanvasReel1.swapColor( pReel1.get(randomNum), mCanvasReel1.isLocked());
                    mCanvasReel2.swapColor( pReel2.get(randomNum), mCanvasReel2.isLocked());
                    mCanvasReel3.swapColor( pReel3.get(randomNum), mCanvasReel3.isLocked());
                    mCanvasReel4.swapColor( pReel4.get(randomNum), mCanvasReel4.isLocked());
                    mCanvasReel5.swapColor( pReel5.get(randomNum), mCanvasReel5.isLocked());

                    counter.setText(String.valueOf(currentCount));


                }
            });

        }
    }
}